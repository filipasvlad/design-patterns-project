package org.example.taskmanager.service;

import lombok.RequiredArgsConstructor;
import org.example.taskmanager.controller.dto.TaskCreateDTO;
import org.example.taskmanager.controller.dto.TaskDTO;
import org.example.taskmanager.controller.dto.TaskUpdateDTO;
import org.example.taskmanager.controller.exceptions.BadCreateTaskException;
import org.example.taskmanager.controller.exceptions.BadUpdateTaskException;
import org.example.taskmanager.dao.Employee;
import org.example.taskmanager.dao.EmployeeRepository;
import org.example.taskmanager.dao.Task;
import org.example.taskmanager.dao.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.taskmanager.converter.TaskConverter.*;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;

    public List<TaskDTO> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        return eltityListToDtoList(taskList);
    }

    public TaskDTO createTask(TaskCreateDTO task) throws BadCreateTaskException{
        Task taskToSave = createDtoToEntity(task);
        Task savedTask = taskRepository.save(taskToSave);

        Iterable<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            savedTask.addObserver(employee);
        }
        savedTask.notifyObservers();
        return entityToDto(savedTask);
    }

    public void deleteTask(Long taskId){
        taskRepository.findById(taskId).ifPresent(taskRepository::delete);
    }

    public TaskDTO updateTask(TaskUpdateDTO taskUpdateDTO) throws BadUpdateTaskException{
        Long idTask = taskUpdateDTO.id();

        if(!taskRepository.existsById(idTask)){
            throw new BadUpdateTaskException("Task with ID " + idTask + " does not exist");
        }

        Task taskToSave = updateDtoToEntity(taskUpdateDTO);
        Task savedTask = taskRepository.save(taskToSave);
        return entityToDto(savedTask);
    }

}

package org.example.taskmanager.controller;


import lombok.RequiredArgsConstructor;
import org.example.taskmanager.controller.dto.TaskCreateDTO;
import org.example.taskmanager.controller.dto.TaskDTO;
import org.example.taskmanager.controller.dto.TaskUpdateDTO;
import org.example.taskmanager.controller.exceptions.BadCreateTaskException;
import org.example.taskmanager.controller.exceptions.BadUpdateTaskException;
import org.example.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    private List<TaskDTO> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    private TaskDTO createTask(@RequestBody @Validated TaskCreateDTO task) throws BadCreateTaskException {
        return taskService.createTask(task);
    }

    @DeleteMapping("/{taskId}")
    private void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }

    @PutMapping("/{taskId}")
    private TaskDTO updateTask(@PathVariable TaskUpdateDTO task) throws BadUpdateTaskException{
        return taskService.updateTask(task);
    }

    @ExceptionHandler({
            BadCreateTaskException.class,
            HttpMessageNotReadableException.class,
            BadUpdateTaskException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleConstraintViolation(Exception exception) {
        return exception.getMessage();
    }

}

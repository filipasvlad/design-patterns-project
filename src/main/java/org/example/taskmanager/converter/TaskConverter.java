package org.example.taskmanager.converter;

import org.example.taskmanager.controller.dto.TaskCreateDTO;
import org.example.taskmanager.controller.dto.TaskDTO;
import org.example.taskmanager.controller.dto.TaskUpdateDTO;
import org.example.taskmanager.dao.Task;
import org.example.taskmanager.dao.TaskStatus;

import java.util.List;

public class TaskConverter {

    public static TaskDTO entityToDto(Task task){
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getDeadline(),
                task.getStatus()
        );
    }

    public static Task createDtoToEntity(TaskCreateDTO taskCreateDTO){
        return Task.builder()
                .id(taskCreateDTO.id())
                .title(taskCreateDTO.title())
                .description(taskCreateDTO.description())
                .priority(taskCreateDTO.priority())
                .deadline(taskCreateDTO.deadline())
                .status(TaskStatus.TO_DO)
                .build();
    }

    public static Task updateDtoToEntity(TaskUpdateDTO taskUpdateDTO){
        return Task.builder()
                .id(taskUpdateDTO.id())
                .title(taskUpdateDTO.title())
                .description(taskUpdateDTO.description())
                .priority(taskUpdateDTO.priority())
                .deadline(taskUpdateDTO.deadline())
                .status(taskUpdateDTO.status())
                .build();
    }

    public static List<TaskDTO> eltityListToDtoList(List<Task> tasks){
        return tasks.stream()
                .map(TaskConverter::entityToDto)
                .toList();
    }
}

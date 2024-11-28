package org.example.taskmanager.controller.dto;
import org.example.taskmanager.dao.TaskPriority;
import org.example.taskmanager.dao.TaskStatus;

public record TaskDTO(
        Long id,
        String title,
        String description,
        TaskPriority priority,
        String deadline,
        TaskStatus status
) { }

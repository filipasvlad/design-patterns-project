package org.example.taskmanager.controller.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import org.example.taskmanager.dao.TaskPriority;
import org.example.taskmanager.dao.TaskStatus;

public record TaskCreateDTO(
        @Null
        Long id,

        @NotBlank
        String title,

        String description,

        @Enumerated(EnumType.STRING)
        TaskPriority priority,

        String deadline,

        @Enumerated(EnumType.STRING)
        TaskStatus status
) { }
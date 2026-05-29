package com.example.taskflow.dto.response;

import com.example.taskflow.model.TaskPriority;
import com.example.taskflow.model.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDateTime deadline;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long projectId;
    private String projectName;
    private Long assigneeId;
    private String assigneeName;
    private Long createdById;
    private String createdByName;
}

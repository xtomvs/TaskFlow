package com.example.taskflow.dto.request;

import com.example.taskflow.model.TaskPriority;
import com.example.taskflow.model.TaskStatus;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class TaskRequest {
    @NotBlank
    @Size(min = 1, max = 100)
    private String title;

    @Size(max = 300)
    private String description;

    @NotNull
    private TaskPriority priority;

    @NotNull
    private TaskStatus status;

    private LocalDateTime dueDate;

    @NotNull
    private Long projectId;

    private Long assigneeId;


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public TaskPriority getPriority() { return priority; }
    public void setPriority(TaskPriority priority) { this.priority = priority; }
    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }
    public LocalDateTime getDueDate() { return dueDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public Long getAssigneeId() { return assigneeId; }
    public void setAssigneeId(Long assigneeId) { this.assigneeId = assigneeId; }

}

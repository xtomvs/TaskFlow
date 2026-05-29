package com.example.taskflow.dto.request;

import com.example.taskflow.model.TaskPriority;
import com.example.taskflow.model.TaskStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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

    @FutureOrPresent(message = "Termin zadania nie może być w przeszłości")
    private LocalDateTime deadline;

    @NotNull
    private Long projectId;

    private Long assigneeId;
}

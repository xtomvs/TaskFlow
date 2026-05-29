package com.example.taskflow.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProjectResponse {
    private Long  id;
    private String projectName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int memberCount;
}

package com.example.taskflow.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectRequest {
    @NotBlank
    @Size(min = 1, max = 100)

    private String projectName;

    @Size(max = 300)
    private String description;
}

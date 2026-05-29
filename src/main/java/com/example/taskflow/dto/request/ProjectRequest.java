package com.example.taskflow.dto.request;

import com.example.taskflow.model.ProjectMember;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

public class ProjectRequest {
    @NotBlank
    @Size(min = 1, max = 100)
    private String projectName;

    @Size(max = 300)
    private String description;


    public String getProjectName() { return projectName; }
    public String getDescription() { return description; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public void setDescription(String description) { this.description = description; }
}

package com.example.taskflow.dto.response;

import com.example.taskflow.model.ProjectMember;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectResponse {
    private Long  id;
    private String projectName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int memberCount;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public int getMemberCount() { return memberCount; }
    public void setMemberCount(int memberCount) { this.memberCount = memberCount; }
}

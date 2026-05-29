package com.example.taskflow.mapper;

import com.example.taskflow.dto.response.ProjectResponse;
import com.example.taskflow.model.Project;

public class ProjectMapper {

    public static ProjectResponse toResponse(Project p) {
        ProjectResponse r = new ProjectResponse();
        r.setId(p.getId());
        r.setProjectName(p.getProjectName());
        r.setDescription(p.getDescription());
        r.setCreatedAt(p.getCreatedAt());
        r.setUpdatedAt(p.getUpdatedAt());
        r.setMemberCount(p.getMembers() != null ? p.getMembers().size() : 0);
        return r;
    }
}

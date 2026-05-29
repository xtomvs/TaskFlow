package com.example.taskflow.mapper;

import com.example.taskflow.dto.response.TaskResponse;
import com.example.taskflow.model.Task;

public class TaskMapper {

    public static TaskResponse toResponse(Task t) {
        TaskResponse r = new TaskResponse();
        r.setId(t.getId());
        r.setTitle(t.getTitle());
        r.setDescription(t.getDescription());
        r.setStatus(t.getStatus());
        r.setPriority(t.getPriority());
        r.setDeadline(t.getDeadline());
        r.setCreatedAt(t.getCreatedAt());
        r.setUpdatedAt(t.getUpdatedAt());

        if (t.getProject() != null) {
            r.setProjectId(t.getProject().getId());
            r.setProjectName(t.getProject().getProjectName());
        }
        if (t.getAssignee() != null) {
            r.setAssigneeId(t.getAssignee().getId());
            r.setAssigneeName(t.getAssignee().getUsername());
        }
        if (t.getCreatedBy() != null) {
            r.setCreatedById(t.getCreatedBy().getId());
            r.setCreatedByName(t.getCreatedBy().getUsername());
        }
        return r;
    }
}

package com.example.taskflow.service;

import com.example.taskflow.dto.request.ProjectRequest;
import com.example.taskflow.dto.response.ProjectResponse;
import com.example.taskflow.mapper.ProjectMapper;
import com.example.taskflow.model.Project;
import com.example.taskflow.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;


    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectMapper::toResponse)
                .toList();
    }

    public ProjectResponse getProjectById(Long id)  {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Project not found: " + id));
        return ProjectMapper.toResponse(project);
    }

    public ProjectResponse create(ProjectRequest request) {
        if (projectRepository.existsByProjectName(request.getProjectName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Project name already exists");
        }

        Project project = new Project();
        project.setProjectName(request.getProjectName());
        project.setDescription(request.getDescription());

        return ProjectMapper.toResponse(projectRepository.save(project));
    }

    public ProjectResponse update(Long id, ProjectRequest request) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Project not found: " + id));

        project.setProjectName(request.getProjectName());
        project.setDescription(request.getDescription());

        return ProjectMapper.toResponse(projectRepository.save(project));
    }

    public void delete(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found: " + id);
        }
        projectRepository.deleteById(id);
    }

}

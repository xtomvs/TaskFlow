package com.example.taskflow.repository;

import com.example.taskflow.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByProjectName(String projectName);
    boolean existsByProjectName(String projectName);
    List<Project> findByMembers_UserId(Long userId);
}

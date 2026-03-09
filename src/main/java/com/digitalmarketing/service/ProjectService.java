package com.digitalmarketing.service;

import com.digitalmarketing.dto.ProjectRequest;
import com.digitalmarketing.model.Project;
import com.digitalmarketing.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(ProjectRequest request) {
        Project project = new Project();
        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setClientName(request.getClientName());
        project.setImageUrl(request.getImageUrl());
        project.setProjectUrl(request.getProjectUrl());
        return projectRepository.save(project);
    }

    public Project updateProject(String id, ProjectRequest request) {
        Project existing = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        existing.setClientName(request.getClientName());
        existing.setImageUrl(request.getImageUrl());
        existing.setProjectUrl(request.getProjectUrl());

        return projectRepository.save(existing);
    }

    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }
}

package com.example.auth.service;

import com.example.auth.entity.Project;
import com.example.auth.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Projet non trouvé"));
    }

    public Project save(Project projet) {
        return repository.save(projet);
    }
}
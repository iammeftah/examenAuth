package com.example.auth.service;

import com.example.auth.entity.Employee;
import com.example.auth.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee non trouvé"));
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public void affecterAProjet(Long employeeId, Long projetId) {
        // TODO: Logique pour affecter un employé à un projet
        // Cette méthode dépendra de votre modèle de données
        // Par exemple, si Projet a une liste d'employés :
        // Employee employee = findById(employeeId);
        // Projet projet = projetService.findById(projetId);
        // projet.getEmployees().add(employee);
        // projetService.save(projet);
    }
}
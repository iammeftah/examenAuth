package com.example.auth.controller;


import com.example.auth.entity.Employee;
import com.example.auth.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeeRestController {
    private final EmployeeService service;

    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> listEmployes() {
        return service.findAll();
    }
}
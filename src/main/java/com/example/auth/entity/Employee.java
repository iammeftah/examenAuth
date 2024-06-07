package com.example.auth.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String skill;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects = new ArrayList<>();

    // Getters and Setters
}

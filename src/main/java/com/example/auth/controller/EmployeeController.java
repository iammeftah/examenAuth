package com.example.auth.controller;

import com.example.auth.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String listeEmployees(Model model) {
        model.addAttribute("employees", service.findAll());
        return "listeEmployees";
    }

    @GetMapping("/affecter")
    public String afficherFormulaire() {
        return "affectationEmployee";
    }

    @PostMapping("/affecter")
    public String affecterEmployee(@RequestParam Long employeeId, @RequestParam Long projetId) {
        service.affecterAProjet(employeeId, projetId);
        return "redirect:/employees";
    }
}
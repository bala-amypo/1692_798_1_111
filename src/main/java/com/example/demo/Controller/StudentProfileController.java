package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public StudentProfile create(@RequestBody StudentProfile s) {
        return service.create(s);
    }

    @GetMapping("/{id}")
    public StudentProfile get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}/status")
    public StudentProfile updateStatus(@PathVariable Long id,
                                       @RequestParam boolean active) {
        return service.updateStatus(id, active);
    }
}

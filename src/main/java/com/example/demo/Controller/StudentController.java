package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentProfileService service;

    public StudentController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public StudentProfile create(@RequestBody StudentProfile student) {
        return service.save(student);
    }

    @GetMapping("/{id}")
    public StudentProfile get(@PathVariable Long id) {
        return service.getById(id);
    }
}

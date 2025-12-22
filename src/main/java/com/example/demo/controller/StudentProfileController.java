package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "StudentProfileController")
public class StudentProfileController {
    @Autowired private StudentProfileService service;

    @PostMapping("/") public StudentProfile create(@RequestBody StudentProfile p) { return service.createStudent(p); }
    @GetMapping("/") public List<StudentProfile> getAll() { return service.getAllStudents(); }
    @GetMapping("/{id}") public StudentProfile getById(@PathVariable Long id) { return service.getStudentById(id); }
    @PutMapping("/{id}/status") public StudentProfile updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return service.updateStudentStatus(id, active);
    }
}
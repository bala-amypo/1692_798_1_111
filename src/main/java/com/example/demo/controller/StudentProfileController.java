package com.example.demo.controller;

import com.example.demo.model.StudentProfile;
import com.example.demo.service.StudentProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Profile Management", description = "Endpoints for managing student profiles")
public class StudentProfileController {

    private final StudentProfileService studentService;

    // Constructor Injection
    public StudentProfileController(StudentProfileService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public ResponseEntity<StudentProfile> createStudent(@RequestBody StudentProfile profile) {
        return ResponseEntity.ok(studentService.createStudent(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentByld(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateStudentStatus(@PathVariable Long id, @RequestParam boolean status) {
        studentService.updateStudentStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/lookup/{studentld}")
    public ResponseEntity<StudentProfile> lookupByStudentId(@PathVariable String studentld) {
        return ResponseEntity.ok(studentService.findByStudentld(studentld));
    }
}
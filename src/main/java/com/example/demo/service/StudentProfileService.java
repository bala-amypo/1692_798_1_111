package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentProfileService {
    @Autowired private StudentProfileRepository repository;

    public StudentProfile createStudent(StudentProfile profile) {
        if (repository.existsByStudentId(profile.getStudentId())) 
            throw new RuntimeException("studentid exists");
        return repository.save(profile);
    }

    public StudentProfile getStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student missing"));
    }

    public List<StudentProfile> getAllStudents() { return repository.findAll(); }

    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile p = getStudentById(id);
        p.setActive(active);
        return repository.save(p);
    }
}
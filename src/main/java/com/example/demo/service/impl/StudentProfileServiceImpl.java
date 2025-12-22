package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile save(StudentProfile profile) {
        return repository.save(profile);
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public StudentProfile findByStudentId(String studentId) {
        return repository.findByStudentId(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with studentId: " + studentId)
                );
    }

    @Override
    public StudentProfile updateStudentStatus(Long id, boolean active) {
        StudentProfile profile = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id)
                );

        profile.setActive(active);   // ✅ update ONLY existing field
        return repository.save(profile);
    }
}

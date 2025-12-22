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
    public StudentProfile saveStudent(StudentProfile studentProfile) {
        return repository.save(studentProfile);
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("StudentProfile not found with id: " + id)
                );
    }
}

package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile createProfile(StudentProfile profile) {
        if (repository.existsByStudentId(profile.getStudentId())) {
            throw new RuntimeException("Student already exists");
        }
        profile.setCreatedAt(LocalDateTime.now());
        return repository.save(profile);
    }
}

package com.example.demo.service.impl;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Autowired
    private StudentProfileRepository repository;

    @Override
    public List<StudentProfile> getAllProfiles() {
        return repository.findAll();
    }

    @Override
    public StudentProfile getProfileById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public StudentProfile saveProfile(StudentProfile profile) {
        return repository.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void toggleActiveStatus(Long id) {
        StudentProfile student = repository.findById(id).orElse(null);
        if (student != null) {
            student.setActive(!student.isActive());
            repository.save(student);
        }
    }
}
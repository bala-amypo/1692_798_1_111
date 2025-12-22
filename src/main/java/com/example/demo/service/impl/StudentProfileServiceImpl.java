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
                        new RuntimeException("Student not found with id: " + id)
                );
    }

    @Override
    public StudentProfile findByStudentId(String studentId) {
        return repository.findAll()
                .stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Student not found with studentId: " + studentId)
                );
    }

    @Override
    public StudentProfile updateStudentStatus(Long id, boolean status) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id)
                );
    }
}

package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;

@Service
public class StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileService(StudentProfileRepository repo) {
        this.repo = repo;
    }

    public StudentProfile create(StudentProfile student) {
        if (repo.findByStudentId(student.getStudentId()).isPresent()) {
            throw new RuntimeException("studentId exists");
        }
        return repo.save(student);
    }

    public StudentProfile getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public StudentProfile updateStatus(Long id, boolean active) {
        StudentProfile s = getById(id);
        s.setActive(active);
        return repo.save(s);
    }
}

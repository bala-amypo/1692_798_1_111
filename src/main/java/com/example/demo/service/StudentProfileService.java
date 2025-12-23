package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentProfileService {

    @Autowired
    private StudentProfileRepository studentRepository;

    // THIS IS THE MISSING METHOD
    public void updateProfileStatus(Long id, boolean status) {
        Optional<StudentProfile> studentData = studentRepository.findById(id);
        
        if (studentData.isPresent()) {
            StudentProfile student = studentData.get();
            student.setIsActive(status); // Assuming your boolean field is named isActive
            studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }
}
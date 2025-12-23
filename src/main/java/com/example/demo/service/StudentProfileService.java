package com.example.demo.service;
import com.example.demo.model.StudentProfile;
import java.util.List;

public interface StudentProfileService {
    StudentProfile createStudent(StudentProfile profile);
    StudentProfile getStudentByld(Long id);
    List<StudentProfile> getAllStudents();
    StudentProfile findByStudentld(String studentld);
    void updateStudentStatus(Long id, boolean active);
}
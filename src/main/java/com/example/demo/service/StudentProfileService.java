package com.example.demo.service;

import com.example.demo.model.StudentProfile;
import java.util.List;

public interface StudentProfileService {
    List<StudentProfile> getAllProfiles();
    StudentProfile getProfileById(Long id);
    StudentProfile saveProfile(StudentProfile profile);
    void deleteProfile(Long id);
    void toggleActiveStatus(Long id);
}
package com.example.demo.repository;

import com.example.demo.model.HabitProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HabitProfileRepository extends JpaRepository<HabitProfile, Long> {
    Optional<HabitProfile> findByStudentId(Long studentId);
}
4. Service Layer (Business Logic)
This is where the "Required error-message keywords" (like studentid exists) are implemented.

Java

// File: service/StudentProfileService.java
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

// File: service/HabitProfileService.java
package com.example.demo.service;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitProfileService {
    @Autowired private HabitProfileRepository repository;

    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        if (habit.getStudyHoursPerDay() < 0) throw new RuntimeException("study hours invalid");
        return repository.save(habit);
    }

    public HabitProfile getHabitByStudent(Long studentId) {
        return repository.findByStudentId(studentId).orElse(null);
    }
}
package com.example.demo.repository;

import com.example.demo.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    // Requirement 4.1: findByStudentld(String studentld)
    Optional<StudentProfile> findByStudentld(String studentld);
    
    // For validation
    boolean existsByStudentld(String studentld);
    boolean existsByEmail(String email);
}
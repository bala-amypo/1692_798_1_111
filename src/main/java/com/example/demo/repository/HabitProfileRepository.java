package com.example.demo.repository;

import com.example.demo.model.HabitProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabitProfileRepository extends JpaRepository<HabitProfile, Long> {

    // Find habit profile by studentId
    Optional<HabitProfile> findByStudentId(String studentId);
}

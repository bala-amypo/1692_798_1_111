package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class HabitProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId;
    private String sleepSchedule; // EARLY, REGULAR, LATE
    private Integer studyHoursPerDay;
    private String cleanlinessLevel; // LOW, MEDIUM, HIGH
    private String noiseTolerance; // LOW, MEDIUM, HIGH
    private String socialPreference; // INTROVERT, BALANCED, EXTROVERT
    private LocalDateTime updatedAt = LocalDateTime.now();
}
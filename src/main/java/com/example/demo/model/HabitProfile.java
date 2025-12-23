package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity @Data
public class HabitProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentld; 
    private String sleepSchedule;
    private Integer studyHoursPerDay;
    private String cleanlinessLevel;
    private String noiseTolerance;
    private String socialPreference;
    private LocalDateTime updatedAt = LocalDateTime.now();
}
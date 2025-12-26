package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import java.time.LocalDateTime;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;
    private int studyHoursPerDay;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum CleanlinessLevel {
        LOW, MEDIUM, HIGH
    }

    public enum NoiseTolerance {
        LOW, MEDIUM, HIGH
    }

    public enum SleepSchedule {
        EARLY_BIRD, NIGHT_OWL, FLEXIBLE
    }

    public enum SocialPreference {
        INTROVERT, AMBIVERT, EXTROVERT
    }

    @Enumerated(EnumType.STRING)
    private CleanlinessLevel cleanlinessLevel;

    @Enumerated(EnumType.STRING)
    private NoiseTolerance noiseTolerance;

    @Enumerated(EnumType.STRING)
    private SleepSchedule sleepSchedule;

    @Enumerated(EnumType.STRING)
    private SocialPreference socialPreference;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public int getStudyHoursPerDay() { return studyHoursPerDay; }
    public void setStudyHoursPerDay(int studyHoursPerDay) { this.studyHoursPerDay = studyHoursPerDay; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

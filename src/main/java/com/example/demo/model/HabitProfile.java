package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getStudentld() { return studentld; }
    public void setStudentld(Long studentld) { this.studentld = studentld; }
    public Integer getStudyHoursPerDay() { return studyHoursPerDay; }
    public void setStudyHoursPerDay(Integer studyHoursPerDay) { this.studyHoursPerDay = studyHoursPerDay; }
    public String getSleepSchedule() { return sleepSchedule; }
    public void setSleepSchedule(String sleepSchedule) { this.sleepSchedule = sleepSchedule; }
    public String getCleanlinessLevel() { return cleanlinessLevel; }
    public void setCleanlinessLevel(String cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }
    public String getNoiseTolerance() { return noiseTolerance; }
    public void setNoiseTolerance(String noiseTolerance) { this.noiseTolerance = noiseTolerance; }
    public String getSocialPreference() { return socialPreference; }
    public void setSocialPreference(String socialPreference) { this.socialPreference = socialPreference; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
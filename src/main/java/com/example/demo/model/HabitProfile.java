package com.example.demo.model;

import java.time.LocalDateTime;

public class HabitProfile {

    private Long id;
    private Long studentId;
    private Integer studyHoursPerDay;
    private LocalDateTime updatedAt;
    // other fields ...

    // Getter & Setter for studyHoursPerDay
    public Integer getStudyHoursPerDay() {
        return studyHoursPerDay;
    }

    public void setStudyHoursPerDay(Integer studyHoursPerDay) {
        this.studyHoursPerDay = studyHoursPerDay;
    }

    // Getter & Setter for updatedAt
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // other getters/setters ...
}

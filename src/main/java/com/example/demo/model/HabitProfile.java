package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    @Enumerated(EnumType.STRING)
    private SleepSchedule sleepSchedule;

    private Integer studyHoursPerDay;

    @Enumerated(EnumType.STRING)
    private Level cleanlinessLevel;

    @Enumerated(EnumType.STRING)
    private Level noiseTolerance;

    @Enumerated(EnumType.STRING)
    private SocialPreference socialPreference;

    private LocalDateTime updatedAt = LocalDateTime.now();

    // getters & setters
}
enum SleepSchedule { EARLY, REGULAR, LATE }
enum Level { LOW, MEDIUM, HIGH }
enum SocialPreference { INTROVERT, BALANCED, EXTROVERT }

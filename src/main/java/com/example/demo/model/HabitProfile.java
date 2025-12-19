package com.example.demo.model;

import jakarta.persistence.*;


@Entity
public class HabitProfile {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Enumerated(EnumType.STRING)
private SleepSchedule sleepSchedule;


@Enumerated(EnumType.STRING)
private Level cleanlinessLevel;


@Enumerated(EnumType.STRING)
private Level noiseTolerance;


private int studyHoursPerDay;


@Enumerated(EnumType.STRING)
private SocialPreference socialPreference;


@OneToOne
private StudentProfile student;


public SleepSchedule getSleepSchedule() { return sleepSchedule; }
public Level getCleanlinessLevel() { return cleanlinessLevel; }
public Level getNoiseTolerance() { return noiseTolerance; }
public int getStudyHoursPerDay() { return studyHoursPerDay; }
}
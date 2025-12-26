package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "habit_profiles")
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    @Enumerated(EnumType.STRING)
    private CleanlinessLevel cleanlinessLevel;

    @Enumerated(EnumType.STRING)
    private NoiseTolerance noiseTolerance;

    @Enumerated(EnumType.STRING)
    private SleepSchedule sleepSchedule;

    @Enumerated(EnumType.STRING)
    private SocialPreference socialPreference;

    private Integer studyHours;

    /* ---------- Constructors ---------- */

    public HabitProfile() {
    }

    public HabitProfile(Long studentId,
                        CleanlinessLevel cleanlinessLevel,
                        NoiseTolerance noiseTolerance,
                        SleepSchedule sleepSchedule,
                        SocialPreference socialPreference,
                        Integer studyHours) {
        this.studentId = studentId;
        this.cleanlinessLevel = cleanlinessLevel;
        this.noiseTolerance = noiseTolerance;
        this.sleepSchedule = sleepSchedule;
        this.socialPreference = socialPreference;
        this.studyHours = studyHours;
    }

    /* ---------- Getters & Setters ---------- */

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public CleanlinessLevel getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public void setCleanlinessLevel(CleanlinessLevel cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public NoiseTolerance getNoiseTolerance() {
        return noiseTolerance;
    }

    public void setNoiseTolerance(NoiseTolerance noiseTolerance) {
        this.noiseTolerance = noiseTolerance;
    }

    public SleepSchedule getSleepSchedule() {
        return sleepSchedule;
    }

    public void setSleepSchedule(SleepSchedule sleepSchedule) {
        this.sleepSchedule = sleepSchedule;
    }

    public SocialPreference getSocialPreference() {
        return socialPreference;
    }

    public void setSocialPreference(SocialPreference socialPreference) {
        this.socialPreference = socialPreference;
    }

    public Integer getStudyHours() {
        return studyHours;
    }

    public void setStudyHours(Integer studyHours) {
        this.studyHours = studyHours;
    }

    /* ---------- ENUMS ---------- */

    public enum CleanlinessLevel {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum NoiseTolerance {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum SleepSchedule {
        EARLY_BIRD,
        NIGHT_OWL
    }

    public enum SocialPreference {
        INTROVERT,
        AMBIVERT,
        EXTROVERT
    }
}

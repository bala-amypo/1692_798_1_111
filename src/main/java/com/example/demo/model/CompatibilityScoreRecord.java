package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long studentAId;
    private Long studentBId;
    private double score;
    private String detailsJson;

    public void setStudentAId(Long studentAId) {
        this.studentAId = studentAId;
    }

    public void setStudentBId(Long studentBId) {
        this.studentBId = studentBId;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setDetailsJson(String detailsJson) {
        this.detailsJson = detailsJson;
    }
}

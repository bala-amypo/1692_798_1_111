package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CompatibilityScoreRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentAld;
    private Long studentBld;
    private Double score;
    private String compatibilityLevel;
    private LocalDateTime computedAt = LocalDateTime.now();
    private String detailsJson;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getStudentAld() { return studentAld; }
    public void setStudentAld(Long studentAld) { this.studentAld = studentAld; }
    public Long getStudentBld() { return studentBld; }
    public void setStudentBld(Long studentBld) { this.studentBld = studentBld; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
    public String getCompatibilityLevel() { return compatibilityLevel; }
    public void setCompatibilityLevel(String level) { this.compatibilityLevel = level; }
    public LocalDateTime getComputedAt() { return computedAt; }
    public void setComputedAt(LocalDateTime cat) { this.computedAt = cat; }
    public String getDetailsJson() { return detailsJson; }
    public void setDetailsJson(String json) { this.detailsJson = json; }
}
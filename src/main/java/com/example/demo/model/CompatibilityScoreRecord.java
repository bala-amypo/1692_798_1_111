package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity @Data
public class CompatibilityScoreRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentAld;
    private Long studentBld;
    private Double score;
    private String compatibilityLevel;
    private LocalDateTime computedAt = LocalDateTime.now();
    private String detailsJson;
}
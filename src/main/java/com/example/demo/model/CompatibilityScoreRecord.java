package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompatibilityScoreRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAld;
    private Long studentBld;
    private Double score;
    
    // Values: LOW / MEDIUM / HIGH / EXCELLENT
    private String compatibilityLevel;
    
    private LocalDateTime computedAt = LocalDateTime.now();
    
    @Column(columnDefinition = "TEXT")
    private String detailsJson;
}
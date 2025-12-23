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
public class MatchAttemptRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long initiatorStudentid;
    private Long candidateStudentid;
    private Long resultScoreld; // References CompatibilityScoreRecord PK
    
    // Status: MATCHED / NOT_COMPATIBLE / PENDING_REVIEW
    private String status;
    
    private LocalDateTime attemptedAt = LocalDateTime.now();
}
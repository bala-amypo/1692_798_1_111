package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity @Data
public class MatchAttemptRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long initiatorStudentid;
    private Long candidateStudentid;
    private Long resultScoreld;
    private String status;
    private LocalDateTime attemptedAt = LocalDateTime.now();
}
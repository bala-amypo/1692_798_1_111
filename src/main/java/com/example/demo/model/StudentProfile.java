package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class StudentProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true) private String studentld; 
    private String fullName;
    @Column(unique = true) private String email;
    private String department;
    private Integer yearLevel;
    private Boolean active;
    private LocalDateTime createdAt = LocalDateTime.now();
}
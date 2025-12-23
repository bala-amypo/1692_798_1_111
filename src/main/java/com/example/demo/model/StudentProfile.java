package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class StudentProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentld; 
    private String fullName;
    private String email;
    private String department;
    private Integer yearLevel;
    private Boolean active; // This generates getActive() and setActive()
    private LocalDateTime createdAt = LocalDateTime.now();
}
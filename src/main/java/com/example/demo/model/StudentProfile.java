package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // If using Lombok, otherwise generate Getters and Setters
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private boolean isActive; // This is the field we are updating
}
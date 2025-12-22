package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {
    @Id
    private Long studentId;
    private String name;
    private String email;
    private boolean active; // Used by setActive() and isActive()
}
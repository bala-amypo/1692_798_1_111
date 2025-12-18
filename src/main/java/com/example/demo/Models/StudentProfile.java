package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_profile",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "studentId"),
           @UniqueConstraint(columnNames = "email")
       })
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;
    private String fullName;
    private String email;
    private String department;
    private Integer yearLevel;
    private Boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();


}

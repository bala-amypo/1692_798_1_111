package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Long studentId;

    private boolean active;

    public Long getStudentId() {
        return studentId;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

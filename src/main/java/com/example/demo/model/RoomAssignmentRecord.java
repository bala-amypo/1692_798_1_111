package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity @Data
public class RoomAssignmentRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;
    private Long studentAld;
    private Long studentBld;
    private String status;
    private LocalDateTime assignedAt = LocalDateTime.now();
}
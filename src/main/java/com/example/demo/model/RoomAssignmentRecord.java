package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RoomAssignmentRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;
    private Long studentAld;
    private Long studentBld;
    private String status;
    private LocalDateTime assignedAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String rn) { this.roomNumber = rn; }
    public Long getStudentAld() { return studentAld; }
    public void setStudentAld(Long id) { this.studentAld = id; }
    public Long getStudentBld() { return studentBld; }
    public void setStudentBld(Long id) { this.studentBld = id; }
    public String getStatus() { return status; }
    public void setStatus(String s) { this.status = s; }
    public LocalDateTime getAssignedAt() { return assignedAt; }
    public void setAssignedAt(LocalDateTime at) { this.assignedAt = at; }
}
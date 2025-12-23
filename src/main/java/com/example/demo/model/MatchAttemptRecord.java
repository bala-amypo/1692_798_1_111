package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MatchAttemptRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long initiatorStudentid;
    private Long candidateStudentid;
    private Long resultScoreld;
    private String status;
    private LocalDateTime attemptedAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInitiatorStudentid() { return initiatorStudentid; }
    public void setInitiatorStudentid(Long id) { this.initiatorStudentid = id; }
    public Long getCandidateStudentid() { return candidateStudentid; }
    public void setCandidateStudentid(Long id) { this.candidateStudentid = id; }
    public Long getResultScoreld() { return resultScoreld; }
    public void setResultScoreld(Long id) { this.resultScoreld = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getAttemptedAt() { return attemptedAt; }
    public void setAttemptedAt(LocalDateTime at) { this.attemptedAt = at; }
}
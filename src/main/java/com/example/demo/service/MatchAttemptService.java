package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import java.util.List;

public interface MatchAttemptService {
    MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt);
    List<MatchAttemptRecord> getAttemptsByStudent(Long studentld);
    void updateAttemptStatus(Long attemptid, String status);
    List<MatchAttemptRecord> getAllMatchAttempts();
    MatchAttemptRecord getAttemptByld(Long id);
}
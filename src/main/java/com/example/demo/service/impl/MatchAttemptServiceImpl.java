package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRecordRepository;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {
    private final MatchAttemptRecordRepository attemptRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    // Requirement: (MatchAttemptRecordRepository, CompatibilityScoreRecordRepository)
    public MatchAttemptServiceImpl(MatchAttemptRecordRepository attemptRepo, CompatibilityScoreRecordRepository scoreRepo) {
        this.attemptRepo = attemptRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
        return attemptRepo.save(attempt);
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(Long studentld) {
        return attemptRepo.findByInitiatorStudentidOrCandidateStudentid(studentld, studentld);
    }

    @Override
    public void updateAttemptStatus(Long attemptid, String status) {
        MatchAttemptRecord a = getAttemptByld(attemptid);
        a.setStatus(status);
        attemptRepo.save(a);
    }

    @Override
    public MatchAttemptRecord getAttemptByld(Long id) {
        return attemptRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<MatchAttemptRecord> getAllMatchAttempts() {
        return attemptRepo.findAll();
    }
}
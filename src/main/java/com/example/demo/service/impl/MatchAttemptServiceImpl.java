package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRepository repository;

    public MatchAttemptServiceImpl(MatchAttemptRepository repository) {
        this.repository = repository;
    }

    @Override
    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord attempt) {
        attempt.setAttemptedAt(LocalDateTime.now());
        attempt.setStatus("PENDING");
        return repository.save(attempt);
    }

    @Override
    public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
        MatchAttemptRecord record = repository.findById(id).orElseThrow();
        record.setStatus(status);
        return repository.save(record);
    }

    @Override
    public List<MatchAttemptRecord> getAttemptsByStudent(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    @Override
    public List<MatchAttemptRecord> getAllAttempts() {
        return repository.findAll();
    }
}

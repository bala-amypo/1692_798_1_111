package com.example.demo.service;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchAttemptService {

    private final MatchAttemptRepository repository;

    public MatchAttemptService(MatchAttemptRepository repository) {
        this.repository = repository;
    }

    public MatchAttemptRecord save(MatchAttemptRecord attempt) {
        return repository.save(attempt);
    }

    public MatchAttemptRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attempt not found"));
    }

    public List<MatchAttemptRecord> getAll() {
        return repository.findAll();
    }
}

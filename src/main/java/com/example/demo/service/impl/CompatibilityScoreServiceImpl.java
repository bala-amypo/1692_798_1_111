package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRepository repository;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompatibilityScoreRecord saveScore(CompatibilityScoreRecord record) {
        record.setCompatibilityLevel("HIGH");
        record.setComputedAt(LocalDateTime.now());
        return repository.save(record);
    }
}

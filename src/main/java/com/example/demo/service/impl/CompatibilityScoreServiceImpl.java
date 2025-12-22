package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRepository repository;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompatibilityScoreRecord save(CompatibilityScoreRecord record) {
        return repository.save(record);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return repository.findAll();
    }
}

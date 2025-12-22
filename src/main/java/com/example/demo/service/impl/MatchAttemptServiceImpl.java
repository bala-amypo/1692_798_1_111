package com.example.demo.service.impl;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.repository.MatchAttemptRepository;
import com.example.demo.service.MatchAttemptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRepository repository;

    public MatchAttemptServiceImpl(MatchAttemptRepository repository) {
        this.repository = repository;
    }

    @Override
    public MatchAttemptRecord save(MatchAttemptRecord record) {
        return repository.save(record);
    }

    @Override
    public List<MatchAttemptRecord> getByStudentId(Long studentId) {
        return repository.findByStudentId(studentId);
    }
}

package com.example.demo.service.impl;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository repository;

    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long a, Long b) {
        if (a.equals(b)) {
            throw new RuntimeException("same student");
        }

        double score = Math.random() * 100;
        String level = score > 80 ? "EXCELLENT" :
                       score > 60 ? "HIGH" :
                       score > 40 ? "MEDIUM" : "LOW";

        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setStudentAId(a);
        record.setStudentBId(b);
        record.setScore(score);
        record.setCompatibilityLevel(level);
        record.setComputedAt(LocalDateTime.now());

        return repository.save(record);
    }

    @Override
    public CompatibilityScoreRecord getScoreById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentId) {
        return repository.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return repository.findAll();
    }
}

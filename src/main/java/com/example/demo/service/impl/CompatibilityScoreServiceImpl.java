package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.repository.CompatibilityScoreRecordRepository;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {
    private final CompatibilityScoreRecordRepository scoreRepo;
    private final HabitProfileRepository habitRepo;

    // Requirement: (CompatibilityScoreRecordRepository, HabitProfileRepository)
    public CompatibilityScoreServiceImpl(CompatibilityScoreRecordRepository scoreRepo, HabitProfileRepository habitRepo) {
        this.scoreRepo = scoreRepo;
        this.habitRepo = habitRepo;
    }

    @Override
    public CompatibilityScoreRecord computeScore(Long idA, Long idB) {
        if (idA.equals(idB)) throw new IllegalArgumentException("same student");

        habitRepo.findByStudentld(idA).orElseThrow(() -> new ResourceNotFoundException("not found"));
        habitRepo.findByStudentld(idB).orElseThrow(() -> new ResourceNotFoundException("not found"));

        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setStudentAld(idA);
        record.setStudentBld(idB);
        record.setScore(75.0); // Mock computation logic
        record.setCompatibilityLevel("HIGH");
        return scoreRepo.save(record);
    }

    @Override
    public CompatibilityScoreRecord getScoreByld(Long id) {
        return scoreRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<CompatibilityScoreRecord> getScoresForStudent(Long studentld) {
        return scoreRepo.findByStudentAldOrStudentBld(studentld, studentld);
    }

    @Override
    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}
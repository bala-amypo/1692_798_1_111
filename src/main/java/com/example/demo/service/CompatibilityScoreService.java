package com.example.demo.service;

import com.example.demo.model.CompatibilityScoreRecord;
import java.util.List;

public interface CompatibilityScoreService {
    CompatibilityScoreRecord computeScore(Long studentAld, Long studentBld);
    CompatibilityScoreRecord getScoreByld(Long id);
    List<CompatibilityScoreRecord> getScoresForStudent(Long studentld);
    List<CompatibilityScoreRecord> getAllScores();
}
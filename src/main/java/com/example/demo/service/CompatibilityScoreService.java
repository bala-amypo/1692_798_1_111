package com.example.demo.service;

import com.example.demo.model.CompatibilityScoreRecord;
import java.util.List;

public interface CompatibilityScoreService {
    CompatibilityScoreRecord save(CompatibilityScoreRecord record);
    List<CompatibilityScoreRecord> getAllScores();
}

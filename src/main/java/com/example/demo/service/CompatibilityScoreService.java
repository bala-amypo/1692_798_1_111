package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.*;
import com.example.demo.repository.*;

@Service
public class CompatibilityScoreService {

    private final HabitProfileRepository habitRepo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public CompatibilityScoreService(HabitProfileRepository h,
                                     CompatibilityScoreRecordRepository s) {
        this.habitRepo = h;
        this.scoreRepo = s;
    }

    public CompatibilityScoreRecord compute(Long a, Long b) {

        if (a.equals(b)) {
            throw new RuntimeException("same student");
        }

        HabitProfile h1 = habitRepo.findByStudentId(a)
                .orElseThrow(() -> new RuntimeException("Habit missing"));
        HabitProfile h2 = habitRepo.findByStudentId(b)
                .orElseThrow(() -> new RuntimeException("Habit missing"));

        double score = 0;

        if (h1.getSleepSchedule() == h2.getSleepSchedule()) score += 25;
        if (h1.getCleanlinessLevel() == h2.getCleanlinessLevel()) score += 25;
        if (h1.getNoiseTolerance() == h2.getNoiseTolerance()) score += 25;
        if (Math.abs(h1.getStudyHoursPerDay() - h2.getStudyHoursPerDay()) <= 1)
            score += 25;

        CompatibilityLevel level =
                score >= 90 ? CompatibilityLevel.EXCELLENT :
                score >= 70 ? CompatibilityLevel.HIGH :
                score >= 40 ? CompatibilityLevel.MEDIUM :
                              CompatibilityLevel.LOW;

        CompatibilityScoreRecord record = new CompatibilityScoreRecord();
        record.setStudentAId(a);
        record.setStudentBId(b);
        record.setScore(score);
        record.setCompatibilityLevel(level);
        record.setDetailsJson("{\"calculated\":true}");

        return scoreRepo.save(record);
    }
}

package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(HabitProfileRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    @Override
    public int calculateCompatibilityScore(String studentId1, String studentId2) {

        HabitProfile h1 = habitRepo.findByStudentId(studentId1)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found for student 1"));

        HabitProfile h2 = habitRepo.findByStudentId(studentId2)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found for student 2"));

        int score = 0;

        // Study hours compatibility
        int diff = Math.abs(h1.getStudyHoursPerDay() - h2.getStudyHoursPerDay());
        if (diff <= 1) score += 25;
        else if (diff <= 3) score += 15;
        else score += 5;

        // Cleanliness
        if (h1.getCleanlinessLevel() == h2.getCleanlinessLevel()) {
            score += 20;
        }

        // Noise tolerance
        if (h1.getNoiseTolerance() == h2.getNoiseTolerance()) {
            score += 20;
        }

        // Sleep schedule
        if (h1.getSleepSchedule() == h2.getSleepSchedule()) {
            score += 20;
        }

        // Social preference
        if (h1.getSocialPreference() == h2.getSocialPreference()) {
            score += 15;
        }

        return score;
    }
}

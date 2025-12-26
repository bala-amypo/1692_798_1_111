package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repository;

    public HabitProfileServiceImpl(HabitProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {

        // ✅ FIX 1: int cannot be null
        if (habit.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("invalid study hours");
        }

        // ✅ FIX 2: correct studentId check
        if (habit.getStudentId() == null || habit.getStudentId().isEmpty()) {
            throw new IllegalArgumentException("studentId cannot be null or empty");
        }

        return repository.findByStudentId(habit.getStudentId())
                .map(existing -> {
                    existing.setStudyHoursPerDay(habit.getStudyHoursPerDay());
                    existing.setCleanlinessLevel(habit.getCleanlinessLevel());
                    existing.setNoiseTolerance(habit.getNoiseTolerance());
                    existing.setSleepSchedule(habit.getSleepSchedule());
                    existing.setSocialPreference(habit.getSocialPreference());
                    existing.setUpdatedAt(LocalDateTime.now());
                    return repository.save(existing);
                })
                .orElseGet(() -> {
                    habit.setCreatedAt(LocalDateTime.now());
                    habit.setUpdatedAt(LocalDateTime.now());
                    return repository.save(habit);
                });
    }

    @Override
    public HabitProfile getHabitByStudent(String studentId) {
        return repository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }

    @Override
    public HabitProfile getHabitById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));
    }
}

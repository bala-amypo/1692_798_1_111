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

        if (habit.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("Invalid study hours");
        }

        return repository.findByStudentId(habit.getStudentId())
                .map(existing -> {
                    habit.setId(existing.getId());
                    habit.setUpdatedAt(LocalDateTime.now());
                    return repository.save(habit);
                })
                .orElseGet(() -> {
                    habit.setCreatedAt(LocalDateTime.now());
                    return repository.save(habit);
                });
    }

    @Override
    public HabitProfile getHabitByStudentId(String studentId) {
        return repository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));
    }

    @Override
    public HabitProfile getHabitById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }
}

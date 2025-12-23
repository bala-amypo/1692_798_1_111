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
        // Fix: Check for invalid study hours keyword
        if (habit.getStudyHoursPerDay() == null || habit.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("invalid study hours");
        }
        
        return repository.findByStudentld(habit.getStudentld())
                .map(existing -> {
                    habit.setId(existing.getId());
                    habit.setUpdatedAt(LocalDateTime.now());
                    return repository.save(habit);
                }).orElseGet(() -> repository.save(habit));
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentld) {
        return repository.findByStudentld(studentld).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }

    @Override
    public HabitProfile getHabitByld(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }
}
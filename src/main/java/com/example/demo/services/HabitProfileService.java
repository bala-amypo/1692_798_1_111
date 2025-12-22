package com.example.demo.service;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitProfileService {

    private final HabitProfileRepository repository;

    public HabitProfileService(HabitProfileRepository repository) {
        this.repository = repository;
    }

    public HabitProfile saveOrUpdate(HabitProfile habit) {
        if (habit.getStudyHoursPerDay() < 0) {
            throw new RuntimeException("study hours must be >= 0");
        }
        return repository.save(habit);
    }

    public HabitProfile getByStudentId(Long studentId) {
        return repository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
    }

    public List<HabitProfile> getAll() {
        return repository.findAll();
    }
}

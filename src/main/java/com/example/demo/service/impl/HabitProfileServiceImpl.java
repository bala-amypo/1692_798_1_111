package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitRepo;

    public HabitProfileServiceImpl(HabitProfileRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habit) {
        if (habit.getStudyHoursPerDay() != null && habit.getStudyHoursPerDay() < 0) {
            throw new IllegalArgumentException("study hours invalid");
        }

        Optional<HabitProfile> existing = habitRepo.findByStudentId(habit.getStudentId());
        if (existing.isPresent()) {
            habit.setId(existing.get().getId());
        }

        habit.setUpdatedAt(LocalDateTime.now());
        return habitRepo.save(habit);
    }

    @Override
    public Optional<HabitProfile> getHabitById(Long id) {
        return habitRepo.findById(id);
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return habitRepo.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
    }

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return habitRepo.findAll();
    }
}

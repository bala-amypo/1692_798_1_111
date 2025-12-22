package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repository;

    public HabitProfileServiceImpl(HabitProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public HabitProfile createOrUpdateHabit(HabitProfile habitProfile) {
        return repository.save(habitProfile);
    }

    @Override
    public List<HabitProfile> getAllHabits() {
        return repository.findAll();
    }

    @Override
    public HabitProfile getHabitById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Habit not found with id: " + id)
                );
    }

    @Override
    public HabitProfile getHabitByStudent(Long studentId) {
        return repository.findAll()
                .stream()
                .filter(h -> h.getStudent() != null
                        && h.getStudent().getId().equals(studentId))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Habit not found for student id: " + studentId)
                );
    }
}

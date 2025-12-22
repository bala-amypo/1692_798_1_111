package com.example.demo.service.impl;

import com.example.demo.model.HabitProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.service.HabitProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    @Autowired
    private HabitProfileRepository repository;

    @Override
    public List<HabitProfile> getAllHabitProfiles() {
        return repository.findAll();
    }

    @Override
    public HabitProfile saveHabit(HabitProfile habit) {
        // Example logic for the error where getStudent() was missing
        if (habit.getStudent() != null) {
            System.out.println("Saving habit for student: " + habit.getStudent().getStudentId());
        }
        return repository.save(habit);
    }
}
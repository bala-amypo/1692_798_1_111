package com.example.demo.service;

import com.example.demo.model.HabitProfile;
import java.util.List;

public interface HabitProfileService {
    List<HabitProfile> getAllHabitProfiles(); // Ensure name matches implementation
    HabitProfile saveHabit(HabitProfile habit);
}
package com.example.demo.service;
import com.example.demo.model.HabitProfile;
import java.util.List;

public interface HabitProfileService {
    HabitProfile createOrUpdateHabit(HabitProfile habit);
    HabitProfile getHabitByStudent(Long studentld);
    List<HabitProfile> getAllHabitProfiles();
    HabitProfile getHabitByld(Long id);
}
package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
@Tag(name = "Habit Profile Management", description = "Endpoints for managing student habits")
public class HabitProfileController {

    private final HabitProfileService habitService;

    public HabitProfileController(HabitProfileService habitService) {
        this.habitService = habitService;
    }

    @PostMapping("/")
    public ResponseEntity<HabitProfile> createOrUpdateHabit(@RequestBody HabitProfile habit) {
        return ResponseEntity.ok(habitService.createOrUpdateHabit(habit));
    }

    @GetMapping("/student/{studentld}")
    public ResponseEntity<HabitProfile> getHabitByStudent(@PathVariable Long studentld) {
        return ResponseEntity.ok(habitService.getHabitByStudent(studentld));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitProfile> getHabitById(@PathVariable Long id) {
        return ResponseEntity.ok(habitService.getHabitByld(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<HabitProfile>> getAllHabits() {
        return ResponseEntity.ok(habitService.getAllHabitProfiles());
    }
}
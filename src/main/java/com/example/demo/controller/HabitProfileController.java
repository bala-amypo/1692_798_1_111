package com.example.demo.controller;

import com.example.demo.model.HabitProfile;
import com.example.demo.service.HabitProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitProfileController {

    @Autowired
    private HabitProfileService service;

    @GetMapping
    public List<HabitProfile> getAll() {
        // This was line 38 - fixed to match service method name
        return service.getAllHabitProfiles(); 
    }
}
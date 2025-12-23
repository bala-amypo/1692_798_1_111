package com.example.demo.controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compatibility")
@Tag(name = "Compatibility Management", description = "Endpoints for computing and viewing compatibility")
public class CompatibilityScoreController {

    private final CompatibilityScoreService compatibilityService;

    public CompatibilityScoreController(CompatibilityScoreService compatibilityService) {
        this.compatibilityService = compatibilityService;
    }

    @PostMapping("/compute/{studentAld}/{studentBld}")
    public ResponseEntity<CompatibilityScoreRecord> computeScore(@PathVariable Long studentAld, @PathVariable Long studentBld) {
        return ResponseEntity.ok(compatibilityService.computeScore(studentAld, studentBld));
    }

    @GetMapping("/student/{studentld}")
    public ResponseEntity<List<CompatibilityScoreRecord>> getScoresForStudent(@PathVariable Long studentld) {
        return ResponseEntity.ok(compatibilityService.getScoresForStudent(studentld));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompatibilityScoreRecord> getScoreById(@PathVariable Long id) {
        return ResponseEntity.ok(compatibilityService.getScoreByld(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<CompatibilityScoreRecord>> getAllScores() {
        return ResponseEntity.ok(compatibilityService.getAllScores());
    }
}
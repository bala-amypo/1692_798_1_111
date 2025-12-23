package com.example.demo.controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match-attempts")
@Tag(name = "Match Attempt Management", description = "Endpoints for logging and tracking match attempts")
public class MatchAttemptController {

    private final MatchAttemptService matchAttemptService;

    public MatchAttemptController(MatchAttemptService matchAttemptService) {
        this.matchAttemptService = matchAttemptService;
    }

    @PostMapping("/")
    public ResponseEntity<MatchAttemptRecord> logMatchAttempt(@RequestBody MatchAttemptRecord attempt) {
        return ResponseEntity.ok(matchAttemptService.logMatchAttempt(attempt));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateAttemptStatus(@PathVariable Long id, @RequestParam String status) {
        matchAttemptService.updateAttemptStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/student/{studentld}")
    public ResponseEntity<List<MatchAttemptRecord>> getAttemptsByStudent(@PathVariable Long studentld) {
        return ResponseEntity.ok(matchAttemptService.getAttemptsByStudent(studentld));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchAttemptRecord> getAttemptById(@PathVariable Long id) {
        return ResponseEntity.ok(matchAttemptService.getAttemptByld(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<MatchAttemptRecord>> getAllAttempts() {
        return ResponseEntity.ok(matchAttemptService.getAllMatchAttempts());
    }
}
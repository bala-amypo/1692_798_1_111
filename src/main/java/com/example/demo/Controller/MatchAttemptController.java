package com.example.demo.Controller;

import com.example.demo.model.MatchAttemptRecord;
import com.example.demo.service.MatchAttemptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match-attempts")
public class MatchAttemptController {

    private final MatchAttemptService service;

    public MatchAttemptController(MatchAttemptService service) {
        this.service = service;
    }

    @PostMapping
    public MatchAttemptRecord create(@RequestBody MatchAttemptRecord record) {
        return service.save(record);
    }

    @GetMapping("/student/{studentId}")
    public List<MatchAttemptRecord> getByStudent(@PathVariable Long studentId) {
        return service.getByStudentId(studentId);
    }
}

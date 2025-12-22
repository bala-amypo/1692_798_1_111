package com.example.demo.Controller;

import com.example.demo.model.CompatibilityScoreRecord;
import com.example.demo.service.CompatibilityScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compatibility-scores")
public class CompatibilityScoreController {

    private final CompatibilityScoreService service;

    public CompatibilityScoreController(CompatibilityScoreService service) {
        this.service = service;
    }

    @PostMapping
    public CompatibilityScoreRecord create(@RequestBody CompatibilityScoreRecord record) {
        return service.save(record);
    }

    @GetMapping
    public List<CompatibilityScoreRecord> getAll() {
        return service.getAllScores();
    }
}

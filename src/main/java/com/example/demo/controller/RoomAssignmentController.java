package com.example.demo.Controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room-assignments")
public class RoomAssignmentController {

    private final RoomAssignmentService service;

    public RoomAssignmentController(RoomAssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public RoomAssignmentRecord create(@RequestBody RoomAssignmentRecord record) {
        return service.save(record);
    }

    @GetMapping
    public List<RoomAssignmentRecord> getAll() {
        return service.getAllAssignments();
    }
}

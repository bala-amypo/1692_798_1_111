package com.example.demo.controller;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.service.RoomAssignmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-assignments")
@Tag(name = "Room Assignment Management", description = "Endpoints for assigning rooms and updating statuses")
public class RoomAssignmentController {

    private final RoomAssignmentService roomAssignmentService;

    public RoomAssignmentController(RoomAssignmentService roomAssignmentService) {
        this.roomAssignmentService = roomAssignmentService;
    }

    @PostMapping("/")
    public ResponseEntity<RoomAssignmentRecord> assignRoom(@RequestBody RoomAssignmentRecord assignment) {
        return ResponseEntity.ok(roomAssignmentService.assignRoom(assignment));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestParam String status) {
        roomAssignmentService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/student/{studentld}")
    public ResponseEntity<List<RoomAssignmentRecord>> getAssignmentsByStudent(@PathVariable Long studentld) {
        return ResponseEntity.ok(roomAssignmentService.getAssignmentsByStudent(studentld));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomAssignmentRecord> getAssignmentById(@PathVariable Long id) {
        return ResponseEntity.ok(roomAssignmentService.getAssignmentByld(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<RoomAssignmentRecord>> getAllAssignments() {
        return ResponseEntity.ok(roomAssignmentService.getAllAssignments());
    }
}
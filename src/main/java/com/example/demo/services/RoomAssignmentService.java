package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAssignmentService {

    private final RoomAssignmentRepository repository;

    public RoomAssignmentService(RoomAssignmentRepository repository) {
        this.repository = repository;
    }

    public RoomAssignmentRecord assign(RoomAssignmentRecord record) {
        return repository.save(record);
    }

    public RoomAssignmentRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
    }

    public List<RoomAssignmentRecord> getAll() {
        return repository.findAll();
    }
}

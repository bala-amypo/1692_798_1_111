package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRepository repository;

    public RoomAssignmentServiceImpl(RoomAssignmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord assignment) {
        assignment.setAssignedAt(LocalDateTime.now());
        assignment.setStatus("ASSIGNED");
        return repository.save(assignment);
    }

    @Override
    public RoomAssignmentRecord updateStatus(Long id, String status) {
        RoomAssignmentRecord record = repository.findById(id).orElseThrow();
        record.setStatus(status);
        return repository.save(record);
    }
}

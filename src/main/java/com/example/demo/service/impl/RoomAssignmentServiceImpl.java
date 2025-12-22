package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRepository repository;

    public RoomAssignmentServiceImpl(RoomAssignmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomAssignmentRecord save(RoomAssignmentRecord record) {
        return repository.save(record);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repository.findAll();
    }
}

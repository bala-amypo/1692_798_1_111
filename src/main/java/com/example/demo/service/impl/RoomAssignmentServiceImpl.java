package com.example.demo.service.impl;

import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repository;

    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord assignment) {
        assignment.setAssignedAt(LocalDateTime.now());
        assignment.setStatus("ACTIVE");
        return repository.save(assignment);
    }

    @Override
    public RoomAssignmentRecord updateStatus(Long id, String status) {
        RoomAssignmentRecord record = repository.findById(id).orElseThrow();
        record.setStatus(status);
        return repository.save(record);
    }

    @Override
    public RoomAssignmentRecord getAssignmentById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentId) {
        return repository.findByStudentAIdOrStudentBId(studentId, studentId);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return repository.findAll();
    }
}

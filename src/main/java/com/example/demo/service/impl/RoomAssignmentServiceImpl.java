package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RoomAssignmentRecord;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.RoomAssignmentRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RoomAssignmentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {
    private final RoomAssignmentRecordRepository assignmentRepo;
    private final StudentProfileRepository studentRepo;

    // Requirement: (RoomAssignmentRecordRepository, StudentProfileRepository)
    public RoomAssignmentServiceImpl(RoomAssignmentRecordRepository assignmentRepo, StudentProfileRepository studentRepo) {
        this.assignmentRepo = assignmentRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord assignment) {
        StudentProfile a = studentRepo.findById(assignment.getStudentAld()).orElseThrow(() -> new ResourceNotFoundException("not found"));
        StudentProfile b = studentRepo.findById(assignment.getStudentBld()).orElseThrow(() -> new ResourceNotFoundException("not found"));

        if (Boolean.FALSE.equals(a.getActive()) || Boolean.FALSE.equals(b.getActive())) {
            throw new IllegalArgumentException("both students must be active");
        }
        return assignmentRepo.save(assignment);
    }

    @Override
    public RoomAssignmentRecord getAssignmentByld(Long id) {
        return assignmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentld) {
        return assignmentRepo.findByStudentAldOrStudentBld(studentld, studentld);
    }

    @Override
    public List<RoomAssignmentRecord> getAllAssignments() {
        return assignmentRepo.findAll();
    }

    @Override
    public void updateStatus(Long id, String status) {
        RoomAssignmentRecord r = getAssignmentByld(id);
        r.setStatus(status);
        assignmentRepo.save(r);
    }
}
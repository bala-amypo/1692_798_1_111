package com.example.demo.service;

import com.example.demo.model.RoomAssignmentRecord;
import java.util.List;

public interface RoomAssignmentService {
    RoomAssignmentRecord assignRoom(RoomAssignmentRecord assignment);
    RoomAssignmentRecord getAssignmentByld(Long id);
    List<RoomAssignmentRecord> getAssignmentsByStudent(Long studentld);
    List<RoomAssignmentRecord> getAllAssignments();
    void updateStatus(Long id, String status);
}
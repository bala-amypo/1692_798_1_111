package com.example.demo.repository;

import com.example.demo.model.RoomAssignmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAssignmentRepository
        extends JpaRepository<RoomAssignmentRecord, Long> {
}

package com.example.demo.repository;

import com.example.demo.model.RoomAssignmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomAssignmentRecordRepository extends JpaRepository<RoomAssignmentRecord, Long> {
    // Requirement 4.6: findByStudentAldOrStudentBld(Long id1, Long id2)
    List<RoomAssignmentRecord> findByStudentAldOrStudentBld(Long id1, Long id2);
}
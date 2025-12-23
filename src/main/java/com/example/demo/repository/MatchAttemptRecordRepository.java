package com.example.demo.repository;

import com.example.demo.model.MatchAttemptRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MatchAttemptRecordRepository extends JpaRepository<MatchAttemptRecord, Long> {
    // Requirement 4.5: findBylnitiatorStudentldOrCandidateStudentid(Long id1, Long id2)
    // Note: Used 'I' (capital i) for Initiator and lowercase 'l' for ld as requested
    List<MatchAttemptRecord> findByInitiatorStudentidOrCandidateStudentid(Long id1, Long id2);
}
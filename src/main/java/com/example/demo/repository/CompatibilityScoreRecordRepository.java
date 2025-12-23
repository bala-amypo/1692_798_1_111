package com.example.demo.repository;

import com.example.demo.model.CompatibilityScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompatibilityScoreRecordRepository extends JpaRepository<CompatibilityScoreRecord, Long> {
    // Requirement 4.3: findByStudentAldAndStudentBld(Long id1, Long id2)
    Optional<CompatibilityScoreRecord> findByStudentAldAndStudentBld(Long id1, Long id2);
    
    // Requirement 4.4: findByStudentAldOrStudentBld(Long id1, Long id2)
    List<CompatibilityScoreRecord> findByStudentAldOrStudentBld(Long id1, Long id2);
}
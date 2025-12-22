package com.example.demo.repository;

import com.example.demo.model.MatchAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchAttemptRepository
        extends JpaRepository<MatchAttempt, Long> {
}

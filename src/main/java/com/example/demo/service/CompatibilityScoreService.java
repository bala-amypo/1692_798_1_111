package com.example.demo.service;

import java.util.List;

public interface CompatibilityScoreService {

    int calculateCompatibilityScore(String studentId1, String studentId2);

    List<Integer> getAllScores();
}

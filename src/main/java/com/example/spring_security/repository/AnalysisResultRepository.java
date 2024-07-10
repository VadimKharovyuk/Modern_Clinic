package com.example.spring_security.repository;

import com.example.spring_security.model.AnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisResultRepository extends JpaRepository<AnalysisResult,Long> {
}

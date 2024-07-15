package com.example.spring_security.repository;

import com.example.spring_security.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagnosisRepository extends JpaRepository<Diagnosis,Long> {
    List<Diagnosis> findByPatientId(Long patientId);
}

package com.example.spring_security.repository;

import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
    List<Prescription> findByDoctor(Doctor doctor);

    List<Prescription> findByPatientId(Long patientId);

}

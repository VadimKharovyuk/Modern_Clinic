package com.example.spring_security.repository;

import com.example.spring_security.model.Patient;
import com.example.spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByUser(User user);
    List<Patient> findByFirstNameContainingIgnoreCase(String firstName);

}

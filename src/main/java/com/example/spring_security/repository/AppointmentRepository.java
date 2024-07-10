package com.example.spring_security.repository;

import com.example.spring_security.model.Appointment;
import com.example.spring_security.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByPatient(Patient patient);

}

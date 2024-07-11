package com.example.spring_security.repository;

import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Optional<Object> findByUser(User user);
}

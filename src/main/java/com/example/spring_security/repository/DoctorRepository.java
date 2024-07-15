package com.example.spring_security.repository;

import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Optional<Object> findByUser(User user);

    @Query("SELECT d FROM Doctor d WHERE d.specialization = :specialization")
    List<Doctor> findBySpecialization(@Param("specialization") String specialization);

    @Query("SELECT DISTINCT d.specialization FROM Doctor d")
    List<String> findDistinctSpecializations();
}

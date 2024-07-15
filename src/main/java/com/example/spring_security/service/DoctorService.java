package com.example.spring_security.service;

import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.User;
import com.example.spring_security.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;



    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }


    public Doctor findByUser(User user) {
        return (Doctor) doctorRepository.findByUser(user).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }
    public List<String> getDistinctSpecializations() {
        return doctorRepository.findDistinctSpecializations();
    }

    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }
}

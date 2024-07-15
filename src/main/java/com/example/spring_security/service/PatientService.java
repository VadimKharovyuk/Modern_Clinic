package com.example.spring_security.service;

import com.example.spring_security.model.Patient;
import com.example.spring_security.model.Prescription;
import com.example.spring_security.model.User;
import com.example.spring_security.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;


    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    public Patient saveOrUpdatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient findByUser(User user) {
        return patientRepository.findByUser(user);
    }

    public List<Patient> findPatientByName(String name){
       return patientRepository.findByFirstNameContainingIgnoreCase(name);
    }


public List<Patient> getPatientsByAgeRange(int minAge, int maxAge) {
    return patientRepository.findPatientsByAgeRange(minAge, maxAge);
}


    }


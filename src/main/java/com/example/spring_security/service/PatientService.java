package com.example.spring_security.service;

import com.example.spring_security.model.Patient;
import com.example.spring_security.model.Prescription;
import com.example.spring_security.model.User;
import com.example.spring_security.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final CacheManager cacheManager;


    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


   @Cacheable(value = "getPatientById" ,key = "#id")
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    public Patient saveOrUpdatePatient(Patient patient) {
        cacheManager.getCache("getPatientById").evict(patient.getId());
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient findByUser(User user) {
        return patientRepository.findByUser(user);
    }

    @Cacheable(value = "findPatientByName", key = "#name")
    public List<Patient> findPatientByName(String name){
       return patientRepository.findByFirstNameContainingIgnoreCase(name);
    }


public List<Patient> getPatientsByAgeRange(int minAge, int maxAge) {
    return patientRepository.findPatientsByAgeRange(minAge, maxAge);
}

}


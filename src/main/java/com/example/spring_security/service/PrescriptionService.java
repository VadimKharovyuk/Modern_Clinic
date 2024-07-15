package com.example.spring_security.service;

import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.Prescription;
import com.example.spring_security.repository.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public List<Prescription> getPrescriptionsByDoctor(Doctor doctor) {
        return prescriptionRepository.findByDoctor(doctor);
    }

    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }

    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Prescription not found"));
    }

}

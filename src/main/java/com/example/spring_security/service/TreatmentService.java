package com.example.spring_security.service;

import com.example.spring_security.model.Treatment;
import com.example.spring_security.repository.TreatmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;



    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    public Treatment getTreatmentById(Long id) {
        return treatmentRepository.findById(id).orElseThrow();
    }

    public Treatment saveTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public void deleteTreatment(Long id) {
        treatmentRepository.deleteById(id);
    }
}

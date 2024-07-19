package com.example.spring_security.service;

import com.example.spring_security.model.Diagnosis;
import com.example.spring_security.repository.DiagnosisRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;

    public List<Diagnosis> getDiagnosesByPatientId(Long id) {
        return diagnosisRepository.findByPatientId(id);
    }

    public Diagnosis saveDiagnosis(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    public void deleteDiagnosis(Long id) {
        diagnosisRepository.deleteById(id);
    }

    public List<Diagnosis> getAllDiagnoses() {
      return   diagnosisRepository.findAll();
    }
}

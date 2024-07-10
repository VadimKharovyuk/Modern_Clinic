package com.example.spring_security.service;

import com.example.spring_security.model.AnalysisResult;
import com.example.spring_security.repository.AnalysisResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AnalysisResultService {

    private final AnalysisResultRepository analysisResultRepository;



    public List<AnalysisResult> getAllAnalysisResults() {
        return analysisResultRepository.findAll();
    }

    public AnalysisResult getAnalysisResultById(Long id) {
        return analysisResultRepository.findById(id).orElseThrow();
    }

    public AnalysisResult saveAnalysisResult(AnalysisResult analysisResult) {
        return analysisResultRepository.save(analysisResult);
    }

    public void deleteAnalysisResult(Long id) {
        analysisResultRepository.deleteById(id);
    }
}

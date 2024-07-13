package com.example.spring_security.controller;

import com.example.spring_security.model.Diagnosis;
import com.example.spring_security.service.DiagnosisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/diagnoses")
public class DiagnosisController {
    private final DiagnosisService diagnosisService;

    @GetMapping
    public String getAllDiagnoses(Model model) {
        List<Diagnosis> diagnoses = diagnosisService.getAllDiagnoses();
        model.addAttribute("diagnoses", diagnoses);
        return "Diagnoses/list";
    }

    @GetMapping("/{id}")
    public String getDiagnosisById(@PathVariable Long id, Model model) {
        Diagnosis diagnosis = diagnosisService.getDiagnosisById(id);
        model.addAttribute("diagnosis", diagnosis);
        return "Diagnoses/detail";
    }

    @GetMapping("/new")
    public String createDiagnosisForm(Model model) {
        model.addAttribute("diagnosis", new Diagnosis());
        return "Diagnoses/form";
    }

    @PostMapping
    public String saveDiagnosis(@ModelAttribute Diagnosis diagnosis) {
        diagnosisService.saveDiagnosis(diagnosis);
        return "redirect:/diagnoses";
    }

    @GetMapping("/edit/{id}")
    public String editDiagnosisForm(@PathVariable Long id, Model model) {
        Diagnosis diagnosis = diagnosisService.getDiagnosisById(id);
        model.addAttribute("diagnosis", diagnosis);
        return "Diagnoses/form";
    }

    @PostMapping("/update/{id}")
    public String updateDiagnosis(@PathVariable Long id, @ModelAttribute Diagnosis diagnosis) {
        diagnosis.setId(id);
        diagnosisService.saveDiagnosis(diagnosis);
        return "redirect:/diagnoses";
    }

    @GetMapping("/delete/{id}")
    public String deleteDiagnosis(@PathVariable Long id) {
        diagnosisService.deleteDiagnosis(id);
        return "redirect:/diagnoses";
    }
}

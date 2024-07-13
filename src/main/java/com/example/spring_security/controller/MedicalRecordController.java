package com.example.spring_security.controller;

import com.example.spring_security.model.MedicalRecord;
import com.example.spring_security.service.MedicalRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/medical-records")
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;

    @GetMapping
    public String getAllMedicalRecords(Model model) {
        List<MedicalRecord> medicalRecords = medicalRecordService.getAllMedicalRecords();
        model.addAttribute("medicalRecords", medicalRecords);
        return "Medical-records/list";
    }

    @GetMapping("/{id}")
    public String getMedicalRecordById(@PathVariable Long id, Model model) {
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordById(id);
        model.addAttribute("medicalRecord", medicalRecord);
        return "Medical-records/detail";
    }

    @GetMapping("/new")
    public String createMedicalRecordForm(Model model) {
        model.addAttribute("medicalRecord", new MedicalRecord());
        return "Medical-records/form";
    }

    @PostMapping
    public String saveMedicalRecord(@ModelAttribute MedicalRecord medicalRecord) {
        medicalRecordService.saveMedicalRecord(medicalRecord);
        return "redirect:/medical-records";
    }

    @GetMapping("/edit/{id}")
    public String editMedicalRecordForm(@PathVariable Long id, Model model) {
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordById(id);
        model.addAttribute("medicalRecord", medicalRecord);
        return "Medical-records/form";
    }

    @PostMapping("/update/{id}")
    public String updateMedicalRecord(@PathVariable Long id, @ModelAttribute MedicalRecord medicalRecord) {
        medicalRecord.setId(id);
        medicalRecordService.saveMedicalRecord(medicalRecord);
        return "redirect:/medical-records";
    }

    @GetMapping("/delete/{id}")
    public String deleteMedicalRecord(@PathVariable Long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return "redirect:/medical-records";
    }
}

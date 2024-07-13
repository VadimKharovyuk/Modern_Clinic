package com.example.spring_security.controller;

import com.example.spring_security.model.Prescription;
import com.example.spring_security.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/prescriptions")
//рецепты
public class PrescriptionController {
    private  final PrescriptionService prescriptionService;

    @GetMapping
    public String getAllPrescriptions(Model model) {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        model.addAttribute("prescriptions", prescriptions);
        return "Prescriptions/list";
    }

    @GetMapping("/{id}")
    public String getPrescriptionById(@PathVariable Long id, Model model) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        model.addAttribute("prescription", prescription);
        return "Prescriptions/detail";
    }

    @GetMapping("/new")
    public String createPrescriptionForm(Model model) {
        model.addAttribute("prescription", new Prescription());
        return "Prescriptions/form";
    }

    @PostMapping
    public String savePrescription(@ModelAttribute Prescription prescription) {
        prescriptionService.savePrescription(prescription);
        return "redirect:/prescriptions";
    }

    @GetMapping("/edit/{id}")
    public String editPrescriptionForm(@PathVariable Long id, Model model) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        model.addAttribute("prescription", prescription);
        return "Prescriptions/form";
    }

    @PostMapping("/update/{id}")
    public String updatePrescription(@PathVariable Long id, @ModelAttribute Prescription prescription) {
        prescription.setId(id);
        prescriptionService.savePrescription(prescription);
        return "redirect:/prescriptions";
    }

    @GetMapping("/delete/{id}")
    public String deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return "redirect:/prescriptions";
    }
}
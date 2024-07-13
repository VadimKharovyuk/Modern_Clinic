package com.example.spring_security.controller;

import com.example.spring_security.model.Treatment;
import com.example.spring_security.service.TreatmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/treatments")
@AllArgsConstructor
//лечение
public class TreatmentController {
    private  final  TreatmentService treatmentService;

    @GetMapping
    public String getAllTreatments(Model model) {
        List<Treatment> treatments = treatmentService.getAllTreatments();
        model.addAttribute("treatments", treatments);
        return "treatments/list";
    }

    @GetMapping("/{id}")
    public String getTreatmentById(@PathVariable Long id, Model model) {
        Treatment treatment = treatmentService.getTreatmentById(id);
        model.addAttribute("treatment", treatment);
        return "treatments/detail";
    }

    @GetMapping("/new")
    public String createTreatmentForm(Model model) {
        model.addAttribute("treatment", new Treatment());
        return "Treatments/form";
    }

    @PostMapping
    public String saveTreatment(@ModelAttribute Treatment treatment) {
        treatmentService.saveTreatment(treatment);
        return "redirect:/treatments";
    }

    @GetMapping("/edit/{id}")
    public String editTreatmentForm(@PathVariable Long id, Model model) {
        Treatment treatment = treatmentService.getTreatmentById(id);
        model.addAttribute("treatment", treatment);
        return "treatments/form";
    }

    @PostMapping("/update/{id}")
    public String updateTreatment(@PathVariable Long id, @ModelAttribute Treatment treatment) {
        treatment.setId(id);
        treatmentService.saveTreatment(treatment);
        return "redirect:/treatments";
    }

    @GetMapping("/delete/{id}")
    public String deleteTreatment(@PathVariable Long id) {
        treatmentService.deleteTreatment(id);
        return "redirect:/treatments";
    }
}
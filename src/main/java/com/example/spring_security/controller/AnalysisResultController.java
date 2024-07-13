package com.example.spring_security.controller;

import com.example.spring_security.model.AnalysisResult;
import com.example.spring_security.service.AnalysisResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/analysis-results")
public class AnalysisResultController {
    private final AnalysisResultService analysisResultService;

    @GetMapping
    public String getAllAnalysisResults(Model model) {
        List<AnalysisResult> analysisResults = analysisResultService.getAllAnalysisResults();
        model.addAttribute("analysisResults", analysisResults);
        return "Analysis-results/list";
    }

    @GetMapping("/{id}")
    public String getAnalysisResultById(@PathVariable Long id, Model model) {
        AnalysisResult analysisResult = analysisResultService.getAnalysisResultById(id);
        model.addAttribute("analysisResult", analysisResult);
        return "Analysis-results/detail";
    }

    @GetMapping("/new")
    public String createAnalysisResultForm(Model model) {
        model.addAttribute("analysisResult", new AnalysisResult());
        return "Analysis-results/form";
    }

    @PostMapping
    public String saveAnalysisResult(@ModelAttribute AnalysisResult analysisResult) {
        analysisResultService.saveAnalysisResult(analysisResult);
        return "redirect:/analysis-results";
    }

    @GetMapping("/edit/{id}")
    public String editAnalysisResultForm(@PathVariable Long id, Model model) {
        AnalysisResult analysisResult = analysisResultService.getAnalysisResultById(id);
        model.addAttribute("analysisResult", analysisResult);
        return "Analysis-results/form";
    }

    @PostMapping("/update/{id}")
    public String updateAnalysisResult(@PathVariable Long id, @ModelAttribute AnalysisResult analysisResult) {
        analysisResult.setId(id);
        analysisResultService.saveAnalysisResult(analysisResult);
        return "redirect:/analysis-results";
    }

    @GetMapping("/delete/{id}")
    public String deleteAnalysisResult(@PathVariable Long id) {
        analysisResultService.deleteAnalysisResult(id);
        return "redirect:/analysis-results";
    }
}

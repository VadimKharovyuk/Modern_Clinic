package com.example.spring_security.controller;

import com.example.spring_security.model.Category;
import com.example.spring_security.model.Doctor;
import com.example.spring_security.service.CategoryService;
import com.example.spring_security.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private  final  DoctorService doctorService;

    @PostMapping("/{categoryId}/doctors")
    public String addDoctorToCategory(@PathVariable Long categoryId, @RequestParam Long doctorId, Model model) {
        categoryService.addDoctorToCategory(categoryId, doctorId);
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "redirect:/categories" ;
    }




    @GetMapping("/{categoryId}/doctors")
    public String getDoctorsForCategory(@PathVariable Long categoryId, Model model) {
        Category category = categoryService.getCategoryById(categoryId);
        List<Doctor> doctors = categoryService.getDoctorsForCategory(categoryId);
        List<Doctor> allDoctors = doctorService.getAllDoctors();

        model.addAttribute("category", category);
        model.addAttribute("doctors", doctors);
        model.addAttribute("allDoctors", allDoctors);

        return "category/category-doctors";
    }

    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "category/categories";
    }

    @PostMapping
    public String createCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/new")
    public String showCreateCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/create-category";
    }
    @PostMapping("/{categoryId}/doctors/{doctorId}")
    public String removeDoctorFromCategory(@PathVariable Long categoryId, @PathVariable Long doctorId) {
        categoryService.removeDoctorFromCategory(categoryId, doctorId);
        return "redirect:/categories";
    }
}

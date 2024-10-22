package com.example.spring_security.controller;
import com.example.spring_security.model.Category;
import com.example.spring_security.model.Contact;
import com.example.spring_security.service.CategoryService;
import com.example.spring_security.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private final CategoryService categoryService;
    private final DoctorService doctorService;

    @GetMapping("/")
    public String home(Model model) {

        List<Category> categories = categoryService.getAllCategories();
        List<String> specializations = doctorService.getDistinctSpecializations();


        // Передача списка категорий в модель для отображения на странице
        model.addAttribute("categories", categories);
        model.addAttribute("contact",new Contact());
        model.addAttribute("specializations", specializations);

        return "homePage"; //
    }
}

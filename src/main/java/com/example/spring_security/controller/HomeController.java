package com.example.spring_security.controller;
import com.example.spring_security.model.Category;
import com.example.spring_security.service.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.spring_security.model.User;
import com.example.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private final CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model) {
        // Получение всех категорий из сервиса (замените на ваш метод получения категорий)
        List<Category> categories = categoryService.getAllCategories();

        // Передача списка категорий в модель для отображения на странице
        model.addAttribute("categories", categories);

        return "homePage"; // Название вашего шаблона Thymeleaf
    }
}

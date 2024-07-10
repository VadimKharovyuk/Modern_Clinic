package com.example.spring_security.controller;

import com.example.spring_security.model.User;
import com.example.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User()); // Добавляем пустого пользователя в модель
        return "LoginRegister";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        // Логика входа
        return "redirect:/dashboard";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Добавляем пустого пользователя в модель
        return "LoginRegister";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
     userService.registerUser(user);
        return "redirect:/dashboard";
    }
}

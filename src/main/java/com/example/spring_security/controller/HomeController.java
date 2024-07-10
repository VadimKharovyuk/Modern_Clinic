package com.example.spring_security.controller;

import com.example.spring_security.model.User;
import com.example.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class HomeController {
    private final UserService userService;
    @GetMapping("/")
    public String home(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "homePage";
    }
}

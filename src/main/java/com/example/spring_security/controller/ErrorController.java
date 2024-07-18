package com.example.spring_security.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ErrorController {

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(HttpServletRequest request, Authentication authentication, Model model) {
        model.addAttribute("errorMessage", "У вас нет прав для доступа к этой странице.");
        return "error/accessDenied";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "error/accessDenied";
    }
}

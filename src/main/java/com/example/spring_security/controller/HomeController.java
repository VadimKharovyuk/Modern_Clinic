package com.example.spring_security.controller;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.spring_security.model.User;
import com.example.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home() {

        return "homePage";
    }
}

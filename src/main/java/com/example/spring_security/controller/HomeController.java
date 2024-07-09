package com.example.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping()
    public String homePage(){
        return "homePage";
    }
}

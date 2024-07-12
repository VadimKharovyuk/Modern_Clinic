package com.example.spring_security.controller;

import com.example.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@AllArgsConstructor
public class UserController {
    private final  UserService userService;
    @GetMapping("/change-password")
    public String showChangePasswordForm() {
        return "Auth/password-change";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 Authentication authentication,
                                 RedirectAttributes redirectAttributes) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        if (userService.changePassword(username, currentPassword, newPassword)) {
            redirectAttributes.addFlashAttribute("successMessage", "Пароль успешно изменен!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Не удалось изменить пароль. Пожалуйста, попробуйте снова.");
        }

        return "redirect:/change-password";
    }
}

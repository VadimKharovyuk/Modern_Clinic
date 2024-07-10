package com.example.spring_security.controller;

import com.example.spring_security.model.User;
import com.example.spring_security.repository.UserRepository;
import com.example.spring_security.service.EmailService;
import com.example.spring_security.service.PasswordGenerator;
import com.example.spring_security.service.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class PasswordResetController {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordService passwordService;



    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password"; // Возвращаем имя HTML файла без расширения
    }

    @PostMapping("/forgot-password")
    @ResponseBody
    public String resetPassword(@RequestParam("email") String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "Пользователь с таким email не найден";
        }

        // Генерируем новый пароль
        String newPassword = PasswordGenerator.generateNewPassword(10); // Пример: генерация пароля длиной 10 символов

        // Сохраняем новый пароль в базе данных (с использованием шифрования)
        user.setPassword(passwordService.encodePassword(newPassword));
        userRepository.save(user);

        // Отправляем пользователю новый пароль по email
        emailService.sendPasswordReset(email, newPassword);

        return "Новый пароль отправлен на указанный email";
    }
}

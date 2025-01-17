package com.example.spring_security.controller;
import com.example.spring_security.model.User;
import com.example.spring_security.repository.UserRepository;
import com.example.spring_security.service.PasswordService;
import com.example.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class AuthController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordService passwordService;


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        return "Auth/Login";

    }    @PostMapping("/login")
    public String login(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser == null || !passwordService.matches(user.getPassword(), existingUser.getPassword())) {
            redirectAttributes.addFlashAttribute("error", "Пароль или логин неправильный");
            return "redirect:/login";
        }

        // Проверка, заблокирован ли пользователь
        if (existingUser.isBlocked()) {
            // Редирект на страницу с сообщением о блокировке
            return "redirect:/blocked";
        }

        // Логика входа
        return "redirect:/";
    }

    @GetMapping("/blocked")
    public String showBlockedPage() {
        return "error/blocked";
    }



    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "Auth/register";
    }
@PostMapping("/register")
public String register(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
    // Проверка, существует ли пользователь с таким email
    if (userService.existsByEmail(user.getEmail())) {
        redirectAttributes.addFlashAttribute("error", "Эта почта уже используется");
        return "redirect:/register";
    }

    userService.registerUser(user);

    // Проверка, заблокирован ли пользователь
    if (userService.isBlocked(user.getUsername())) {
        redirectAttributes.addFlashAttribute("error", "Этот аккаунт заблокирован. Обратитесь к администратору для разблокировки.");
        return "redirect:/register";
    }

    return "redirect:/login";
}



}
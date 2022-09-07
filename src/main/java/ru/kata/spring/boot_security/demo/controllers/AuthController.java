package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.models.User;

@Controller
@RequestMapping("/auth")
public class AuthController {
//
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
//

    public String registrationPage(@ModelAttribute("user") User user) {
        return "auth/registration";
    }
}
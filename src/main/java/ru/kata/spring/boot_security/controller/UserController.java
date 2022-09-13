package ru.kata.spring.boot_security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.model.RoleConverter;
import ru.kata.spring.boot_security.model.User;
import ru.kata.spring.boot_security.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String userPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.getUserByName(userDetails.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("sRoles", RoleConverter.roleToString( new ArrayList<>(user.getRoles().stream().toList())));


        return "user";
    }

}

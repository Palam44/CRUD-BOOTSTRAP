package ru.kata.spring.boot_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.model.User;
import ru.kata.spring.boot_security.service.RoleService;
import ru.kata.spring.boot_security.service.UserService;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping()
    public String index(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.getUserByName(userDetails.getUsername());
        model.addAttribute("me", user);
        model.addAttribute("createUser", new User());
        model.addAttribute("mySRoles", RoleConverter.roleToString( new ArrayList<>(user.getRoles().stream().toList())));
        model.addAttribute("sRoles", RoleConverter.roleToString( new ArrayList<>(roleService.getAllRoles().stream().toList())));
        model.addAttribute("users", userService.getAllUsers());

        return "admin";
    }

    @PatchMapping("/{id}/update")
    public String updateUser(@PathVariable Long id,
                             @RequestParam(value = "eFistName", required = false) String fistName,
                             @RequestParam(value = "eLastName", required = false) String lastName,
                             @RequestParam(value = "eAge", required = false) Integer age,
                             @RequestParam(value = "eEmail", required = false) String email,
                             @RequestParam(value = "eRole", required = false) String role) {

        if ( role != null) {
            User user = new User();
            user.setId(id);
            user.setFistName(fistName);
            user.setLastName(lastName);
            user.setAge(age);
            user.setEmail(email);
            user.setRoles(role.equals("Admin") ? roleService.getAllRoles() : roleService.getByName(RoleConverter.stringToRole(role).getName()) );

            userService.update(user);
        }

        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable(value = "id", required = false) Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "aRole", required = false) String role) {

        if (role != null && userService.getUserByName(user.getUsername()) == null ) {

            user.setRoles(role.equals("Admin") ? roleService.getAllRoles() : roleService.getByName(RoleConverter.stringToRole(role).getName()) );
            userService.add(user);
        }

        return "redirect:/admin";
    }




}
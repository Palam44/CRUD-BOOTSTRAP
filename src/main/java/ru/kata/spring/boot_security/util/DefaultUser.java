//package ru.kata.spring.boot_security.util;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Component;
//import ru.kata.spring.boot_security.model.Role;
//import ru.kata.spring.boot_security.model.User;
//import ru.kata.spring.boot_security.service.RoleService;
//import ru.kata.spring.boot_security.service.UserService;
//
//@Component
//public class DefaultUser {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleService roleService;
//
//    @PostConstruct
//    private void initialize() {
//        Role roleAdmin = new Role("ROLE_ADMIN");
//        Role roleUser = new Role("ROLE_USER");
//        roleService.saveRole(roleAdmin);
//        roleService.saveRole(roleUser);
//
//
//        User admin = new User();
//        admin.setAge(23);
//        admin.setFistName("Anna");
//        admin.setLastName("Teplova");
//        admin.setEmail("1@1");
//        admin.setUsername("Anna123");
//        admin.setPassword("123");
//
//        admin.addRole(roleAdmin);
//
//
//        User user = new User();
//        user.setAge(1);
//        user.setFistName("user");
//        user.setLastName("user");
//        user.setEmail("12@12");
//        user.setUsername("user1");
//        user.setPassword("1");
//        user.addRole(roleUser);
//
//        userService.add(admin);
//        userService.add(user);
//    }
//}

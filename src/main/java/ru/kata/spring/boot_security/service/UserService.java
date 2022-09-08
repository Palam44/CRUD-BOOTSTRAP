package ru.kata.spring.boot_security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void add(User user);
    User getUserById(Long id);
    void delete(Long id);
    void update(User user, Long id);
    List<User> getAllUsers();
    User getUserByName(String username);

}

package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

//@Repository
public interface UserRepository{
    User findUserByEmail(String email);
    void save(User user);
    void deleteById(int id);
    void update(User user);
    User getById(int id);
    List<User> findAll();
}
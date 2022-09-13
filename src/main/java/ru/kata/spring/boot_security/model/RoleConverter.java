package ru.kata.spring.boot_security.model;


import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RoleConverter {

    static String prefix = "ROLE_";

    static public List<String> roleToString(List<Role> roles) {
        return roles.stream().map(RoleConverter::roleToString).toList();
    }
    static public String roleToString(Role role) {
        return role.getName().split("_")[1].toLowerCase().replaceFirst(( (Character) role.getName().split("_")[1].toLowerCase().charAt(0)).toString(),( (Character) role.getName().split("_")[1].toUpperCase().toCharArray()[0]).toString());
    }

    static public List<Role> stringToRole(List<String> strings) {
        return strings.stream().map(RoleConverter::stringToRole).toList();
    }
    static public Role stringToRole(String role) {
        return new Role(prefix + role.toUpperCase());
    }

}

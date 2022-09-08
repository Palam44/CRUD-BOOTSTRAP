package ru.kata.spring.boot_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.dao.RoleDao;
import ru.kata.spring.boot_security.model.Role;

import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Set<Role> getByName(String name) {
        return roleDao.getByName(name);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

}

package io.spring.security.demo.service;

import io.spring.security.demo.entity.Role;
import io.spring.security.demo.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
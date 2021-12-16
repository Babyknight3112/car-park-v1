package com.project.carparkv1.Security.SecurityService;

import com.project.carparkv1.Security.Entity.Role;
import com.project.carparkv1.Security.Entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
    Boolean existUser(String username);
}

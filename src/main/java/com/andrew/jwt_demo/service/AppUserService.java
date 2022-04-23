package com.andrew.jwt_demo.service;

import com.andrew.jwt_demo.domain.AppUser;
import com.andrew.jwt_demo.domain.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String role);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}

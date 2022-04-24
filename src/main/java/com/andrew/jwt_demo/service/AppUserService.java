package com.andrew.jwt_demo.service;

import com.andrew.jwt_demo.domain.AppUser;
import com.andrew.jwt_demo.domain.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveAppUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToAppUser(String username, String role);
    AppUser getAppUser(String username);
    List<AppUser> getAppUsers();
}

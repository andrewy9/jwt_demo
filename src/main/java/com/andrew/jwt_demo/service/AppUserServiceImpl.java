package com.andrew.jwt_demo.service;

import com.andrew.jwt_demo.domain.AppUser;
import com.andrew.jwt_demo.domain.Role;
import com.andrew.jwt_demo.repo.AppUserRepo;
import com.andrew.jwt_demo.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService{
    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;

    @Override
    public AppUser saveAppUser(AppUser user) {
        log.info("Saving new user {} to the database", user.getName());
        return appUserRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToAppUser(String username, String roleName) {
        log.info("Adding a role {} to user {}", roleName, username);
        AppUser user = appUserRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getAppUser(String username) {
        log.info("Fetching user {}", username);
        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getAppUsers() {
        log.info("Fetching users");
        return appUserRepo.findAll();
    }
}

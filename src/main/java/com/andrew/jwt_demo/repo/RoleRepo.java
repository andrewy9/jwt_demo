package com.andrew.jwt_demo.repo;

import com.andrew.jwt_demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

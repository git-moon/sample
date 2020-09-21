package com.example.sample.persistence.role;

import com.example.sample.domain.main.role.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}

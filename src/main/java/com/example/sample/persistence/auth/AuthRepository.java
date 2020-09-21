package com.example.sample.persistence.auth;

import com.example.sample.domain.main.auth.Auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Integer> {
    
}

package com.example.sample.persistence.member;

import com.example.sample.domain.main.member.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    
}

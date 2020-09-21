package com.example.sample;

import java.time.LocalDateTime;

import com.example.sample.domain.main.board.Board;
import com.example.sample.domain.main.role.Role;
import com.example.sample.persistence.board.BoardRepository;
import com.example.sample.persistence.role.RoleRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class myTests {
    
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void createAuthTest() {
        Role roleUser = Role.builder()
            .roleName("ROLE_USER")
            .description("아무권한없음")
            .build();
        
        Role roleAdmin = Role.builder()
            .roleName("ROLE_ADMIN")
            .description("전지전능")
            .build();
        
        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);
    }

    @Test
    public void createBoardTest() {
        for (int i = 1; i < 21; i++) {
            Board board = Board.builder()
                .contents("생성 테스트" + i)
                .createdTime(LocalDateTime.now())
                .modifiedTime(LocalDateTime.now())
                .build();
            
            boardRepository.save(board);
        }
    }
}

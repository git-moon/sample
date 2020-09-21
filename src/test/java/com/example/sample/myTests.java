package com.example.sample;

import java.time.LocalDateTime;

import com.example.sample.domain.main.auth.Auth;
import com.example.sample.domain.main.board.Board;
import com.example.sample.persistence.auth.AuthRepository;
import com.example.sample.persistence.board.BoardRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class myTests {
    
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void createAuthTest() {
        Auth authUser = Auth.builder()
            .authority("ROLE_USER")
            .description("아무권한없음")
            .build();
        
        Auth authAdmin = Auth.builder()
            .authority("ROLE_ADMIN")
            .description("전지전능")
            .build();
        
        authRepository.save(authUser);
        authRepository.save(authAdmin);
    }

    @Test
    public void createBoardTest() {
        for (int i = 1; i < 11; i++) {
            Board board = Board.builder()
                .contents("생성 테스트" + i)
                .createdTime(LocalDateTime.now())
                .modifiedTime(LocalDateTime.now())
                .build();
            
            boardRepository.save(board);
        }
    }
}

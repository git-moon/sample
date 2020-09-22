package com.example.sample;

import java.time.LocalDateTime;

import com.example.sample.domain.main.board.Board;
import com.example.sample.domain.main.member.Member;
import com.example.sample.domain.main.role.Role;
import com.example.sample.persistence.board.BoardRepository;
import com.example.sample.persistence.member.MemberRepository;
import com.example.sample.persistence.role.RoleRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class myTests {
    
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void projectInit() {
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

        Member memberAdmin = Member.builder()
            .mid("godgod")
            .mpw("1234")
            .mname("어드민")
            .build();
        
        Member memberUser = Member.builder()
            .mid("human")
            .mpw("1234")
            .mname("일반유저")
            .build();
        
        memberAdmin = memberRepository.save(memberAdmin);
        memberRepository.save(memberUser);

        for (int i = 1; i < 51; i++) {
            Board board = Board.builder()
                .title("제목" + i)
                .memberIdx(memberAdmin.getIdx())
                .contents("생성 테스트" + i)
                .createdTime(LocalDateTime.now())
                .modifiedTime(LocalDateTime.now())
                .build();
            
            boardRepository.save(board);
        }
    }

    @Test
    public void createRoleTest() {
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
        for (int i = 1; i < 51; i++) {
            Board board = Board.builder()
                .contents("생성 테스트" + i)
                .createdTime(LocalDateTime.now())
                .modifiedTime(LocalDateTime.now())
                .build();
            
            boardRepository.save(board);
        }
    }
}

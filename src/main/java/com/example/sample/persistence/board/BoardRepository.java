package com.example.sample.persistence.board;

import com.example.sample.domain.main.board.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    public Page<Board> findAllByOrderByIdxDesc(Pageable pageable);
}

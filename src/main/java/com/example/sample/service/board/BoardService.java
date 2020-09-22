package com.example.sample.service.board;

import java.util.List;

import com.example.sample.domain.main.board.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    public Board addBoard(Board board);
    public Board modifyBoard(Board board);
    public void removeBoard(Integer boardIdx) throws Exception;
    public Page<Board> getBoards(Pageable pageable);
    public Board getBoard(Integer boardIdx);
}

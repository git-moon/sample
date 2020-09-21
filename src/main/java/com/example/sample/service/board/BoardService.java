package com.example.sample.service.board;

import java.util.List;

import com.example.sample.domain.main.board.Board;

public interface BoardService {

    public Board addBoard(Board board);
    public Board modifyBoard(Board board);
    public void removeBoard(Integer boardIdx) throws Exception;
    public List<Board> getBoards();
    public Board getBoard(Integer boardIdx);
}

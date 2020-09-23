package com.example.sample.service.board;

import com.example.sample.domain.main.board.Board;
import com.example.sample.dto.board.BoardReqDto;

import org.springframework.data.domain.Page;

public interface BoardService {

    public Board addBoard(Board board);
    public Board modifyBoard(Board board);
    public void removeBoard(Integer boardIdx) throws Exception;
    public Page<Board> getBoards(BoardReqDto boardReqDto);
    public Board getBoard(Integer boardIdx);
}

package com.example.sample.service.board;

import java.util.List;

import com.example.sample.domain.main.board.Board;
import com.example.sample.persistence.board.BoardRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

	@Override
	public Board addBoard(Board board) {
		Board createdBoard = boardRepository.save(board);
		return createdBoard;
	}

	@Override
	public Board modifyBoard(Board board) {
		Board origin = boardRepository.findById(board.getIdx()).orElse(null);
		if (origin == null) {
			return null;
		}
		BeanUtils.copyProperties(board, origin);
		origin = boardRepository.save(origin);
		return origin;
	}

	@Override
	public void removeBoard(Integer boardIdx) throws Exception {
		boardRepository.deleteById(boardIdx);
	}

	@Override
	public List<Board> getBoards() {
        List<Board> boards = boardRepository.findAll();
		return boards;
	}

	@Override
	public Board getBoard(Integer boardIdx) {
		Board board = boardRepository.findById(boardIdx).orElse(null);
		return board;
	}
    
}

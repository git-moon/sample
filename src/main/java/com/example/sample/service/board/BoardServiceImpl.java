package com.example.sample.service.board;

import java.time.LocalDateTime;
import java.util.List;

import com.example.sample.domain.main.board.Board;
import com.example.sample.persistence.board.BoardRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

	@Override
	public Board addBoard(Board board) {
		board.setCreatedTime(LocalDateTime.now());
		board.setModifiedTime(LocalDateTime.now());
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
	public Page<Board> getBoards(Pageable pageable) {
        Page<Board> boards = boardRepository.findAllByOrderByIdxDesc(pageable);
		return boards;
	}

	@Override
	public Board getBoard(Integer boardIdx) {
		Board board = boardRepository.findById(boardIdx).orElse(null);
		return board;
	}
    
}

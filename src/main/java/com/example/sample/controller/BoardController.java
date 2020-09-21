package com.example.sample.controller;

import java.util.List;

import com.example.sample.domain.main.board.Board;
import com.example.sample.dto.board.BoardDto;
import com.example.sample.service.board.BoardService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/board")
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public List<BoardDto> index() throws Exception {
        List<Board> boards = boardService.getBoards();
        return modelMapper.map(boards, new TypeToken<List<BoardDto>>(){}.getType());
    }

    @GetMapping(value = "/{idx}")
    public BoardDto getBoard(@PathVariable Integer idx) throws Exception {
        Board board = boardService.getBoard(idx);
        return board == null ? null : modelMapper.map(board, BoardDto.class);
    }

    @PostMapping(value = "/posting")
    public BoardDto add(@RequestBody BoardDto boardDto) throws Exception {
        Board postingBody = modelMapper.map(boardDto, Board.class);
        postingBody = boardService.addBoard(postingBody);
        return postingBody == null ? null : modelMapper.map(postingBody, BoardDto.class);
    }

    @PutMapping(value = "/modify")
    public BoardDto modify(@RequestBody BoardDto boardDto) throws Exception {
        Board postingBody = modelMapper.map(boardDto, Board.class);
        postingBody = boardService.addBoard(postingBody);
        return postingBody == null ? null : modelMapper.map(postingBody, BoardDto.class);
    }

    @DeleteMapping(value = "/remove")
    public Boolean remove(@PathVariable Integer idx) throws Exception {
        // Exception이 발생하지 않으면 삭제되었다고 본다.
        boardService.removeBoard(idx);
        return true;
    }
}

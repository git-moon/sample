package com.example.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.sample.domain.main.board.Board;
import com.example.sample.dto.board.BoardDto;
import com.example.sample.dto.board.BoardReqDto;
import com.example.sample.lib.Paging;
import com.example.sample.lib.PagingResponse;
import com.example.sample.service.board.BoardService;
import com.example.sample.utils.ModelMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping()
    public PagingResponse<BoardDto> index(BoardReqDto boardReqDto) throws Exception {
        Page<Board> pageData = boardService.getBoards(boardReqDto);
        List<Board> boards = pageData.getContent();
        Paging paging = Paging.builder()
            .page(boardReqDto.getPage())
            .size(boardReqDto.getSize())
            .totalCount((int) pageData.getTotalElements())
            .build();
        PagingResponse<BoardDto> resp = new PagingResponse<BoardDto>(paging, boards.stream().map(BoardDto::of).collect(Collectors.toList()));
        return resp;
    }

    @GetMapping(value = "/{idx}")
    public BoardDto getBoard(@PathVariable Integer idx) throws Exception {
        Board board = boardService.getBoard(idx);
        return board == null ? null : BoardDto.of(board);
    }

    @PostMapping(value = "/posting")
    public BoardDto add(@RequestBody BoardDto boardDto) throws Exception {
        Board postingBody = ModelMapperUtil.MODEL_MAPPER.map(boardDto, Board.class);
        postingBody = boardService.addBoard(postingBody);
        return postingBody == null ? null : BoardDto.of(postingBody);
    }

    @PutMapping(value = "/modify")
    public BoardDto modify(@RequestBody BoardDto boardDto) throws Exception {
        Board postingBody = ModelMapperUtil.MODEL_MAPPER.map(boardDto, Board.class);
        postingBody = boardService.addBoard(postingBody);
        return postingBody == null ? null : BoardDto.of(postingBody);
    }

    @DeleteMapping(value = "/{idx}")
    public Boolean remove(@PathVariable Integer idx) throws Exception {
        // Exception이 발생하지 않으면 삭제되었다고 본다.
        boardService.removeBoard(idx);
        return true;
    }
}

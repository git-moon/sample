package com.example.sample.dto.board;

import java.time.LocalDateTime;

import com.example.sample.domain.main.board.Board;
import com.example.sample.utils.ModelMapperUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    
    private Integer idx;
    private Integer memberIdx;
    private String title;
    private String subTitle;
    private String contents;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public static BoardDto of(Board e) {
        return ModelMapperUtil.MODEL_MAPPER.map(e, BoardDto.class);
    }
}

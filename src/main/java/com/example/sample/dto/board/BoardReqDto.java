package com.example.sample.dto.board;

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
public class BoardReqDto {
    @Builder.Default
    private Integer page = 1;

    @Builder.Default
    private Integer size = 20;

    private String keyword;
}

package com.examples.crazy.simpleboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor
public class BoardsDto {

    private Long boardId;
    private String title;
    private String memberAlias;
    private int readCount;
    private LocalDateTime createdDate;
}

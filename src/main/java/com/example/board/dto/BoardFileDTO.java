package com.example.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardFileDTO {
    private Long id;
    private Long boardId;
    private String originalFileName; // 원본파일 이름
    private String storedFileName; // 저장파일 이름
}

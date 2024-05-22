package com.example.board.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long id; // 글번호
    private String boardWriter; // 작성자
    private String boardPass; // 게시글 비밀번호
    private String boardTitle; // 제목
    private String boardContents; // 내용
    private int boardHits; // 조회수
    private String createdAt; // 작성시간

}

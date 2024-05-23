package com.example.board.dto;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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
    private int fileAttached; // 파일첨부 유무판단
    private MultipartFile boardFile; // 파일자체를 받기위한 필드

}

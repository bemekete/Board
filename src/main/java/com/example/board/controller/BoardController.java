package com.example.board.controller;

import com.example.board.dto.BoardDTO;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor // final이 붙은 필드만 가지고 생성자 생성
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String save(){
        return "save";
    }

    // 글 입력하기
    @PostMapping("/save")
    public String save(BoardDTO boardDTO){
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "redirect:/list";
    }

    // 전체목록 불러오기
    @GetMapping("/list")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        System.out.println("boardDTOList = " + boardDTOList);
        return "list";
    }

    // 게시글 하나 상세보기
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        // 조회수 처리
        boardService.updateHits(id);
        // 상세내용 가져오기
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        System.out.println("boardDTO = " + boardDTO);
        return "detail";
    }

    // 게시글 수정
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(BoardDTO boardDTO, Model model){
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board",dto);
        return "detail";
    }
}

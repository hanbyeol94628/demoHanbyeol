package com.example.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BoardVO;
import com.example.service.BoardService;

@Controller
public class BoardController {

	@Resource(name="com.example.service")
	BoardService boardService;
	
	// 리스트
	@RequestMapping("/list")
	private String boardList(Model model) throws Exception{
		model.addAttribute("list", boardService.boardListService());
		return "list";
	}
	
	@RequestMapping("/detail/{no}")
	private String boardDetail(@PathVariable int no, Model model) throws Exception{
		model.addAttribute("detail", boardService.boardDetailService(no));
		return "detail";
	}
	
	@RequestMapping("/insertProc")
	private int boardInsertProc(HttpServletRequest request) throws Exception{
		BoardVO board = (BoardVO) request.getParameterMap();
		return boardService.boardInsertService(board);
	}
	
	// 수정 폼 호출
	@RequestMapping("/update/{no}") 
	private String boardUpdateForm(@PathVariable int no, Model model) throws Exception{
		model.addAttribute("detail", boardService.boardDetailService(no));
		return "update";
	}
	
	@RequestMapping("/updateProc")
	private int boardUpdateProc(HttpServletRequest request) throws Exception{
		BoardVO board = (BoardVO) request.getParameterMap();
		return boardService.boardUpdateService(board);
	}
	
	@RequestMapping("/delete/{no}")
	private String boardDelete(@PathVariable int no) throws Exception{
		boardService.boardDeleteService(no);
		return "redirect:/list";
	}
	
	
}

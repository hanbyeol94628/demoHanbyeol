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

	@Resource(name="com.example.service.BoardService")
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
	
	// 작성 폼 호출
	@RequestMapping("/insert")
	private String boardInsertForm() {
		return "insert";
	}
	
	
	@RequestMapping("/insertProc")
	private String boardInsertProc(HttpServletRequest request) throws Exception{
		
		BoardVO board = new BoardVO();
		
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));
		
		boardService.boardInsertService(board);
		
		return "redirect:/list";
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

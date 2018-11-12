package com.example.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}

package com.example.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.CommentVO;
import com.example.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Resource(name="com.example.service.CommentService")
	CommentService commentService;
	
	@RequestMapping("/list")
	@ResponseBody
	private List<CommentVO> commentServiceList(Model model) throws Exception{
		return commentService.commentListService();
	}
	
	@RequestMapping("/add")
	@ResponseBody
	private int commentServiceInsert(@RequestParam int no, @RequestParam String content, @RequestParam String writer) throws Exception{
		
		CommentVO comment = new CommentVO();
		comment.setNo(no);
		comment.setContent(content);
		comment.setWriter(writer);
		
		return commentService.commentInsertService(comment);
	}
}

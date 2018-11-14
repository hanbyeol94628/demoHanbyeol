package com.example.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.BoardVO;
import com.example.domain.CommentVO;
import com.example.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Resource(name="com.example.service.CommentService")
	CommentService commentService;
	
	@RequestMapping("/list")
	@ResponseBody
	private List<CommentVO> commentServiceList(Model model, @RequestParam int no) throws Exception{
		return commentService.commentListService(no);
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
	
	@RequestMapping("/delete/{cno}")
	@ResponseBody
	private int commentServiceDelete(@PathVariable int cno, Model model) throws Exception {
		return commentService.commentDeleteService(cno);
	}
	
	
	@RequestMapping("/update/{cno}")
	private int boardUpdateProc(@PathVariable int cno, @RequestParam String content, HttpServletRequest request) throws Exception{
       
		CommentVO newComment = commentService.commentDetailService(cno);
		newComment.setContent(content);
        
        return commentService.commentUpdateService(newComment);

	}
}

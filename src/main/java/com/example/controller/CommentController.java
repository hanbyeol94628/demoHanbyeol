package com.example.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.BoardVO;
import com.example.domain.CommentVO;
import com.example.service.BoardService;
import com.example.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Resource(name="com.example.service.CommentService")
	CommentService commentService;
	
	@Resource(name="com.example.service.BoardService")
	BoardService boardService;
	
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
		
		BoardVO board = boardService.boardDetailService(no);
		board.setCommentNum(commentService.commentCount(no)+1);
		boardService.boardUpdateComment(board);
		
		return commentService.commentInsertService(comment);
	}
	
	@RequestMapping("/delete/{cno}/{no}")
	@ResponseBody
	private int commentServiceDelete(@PathVariable int cno, @PathVariable int no) throws Exception {
		
		BoardVO board = boardService.boardDetailService(no);
		board.setCommentNum(commentService.commentCount(no)-1);
		boardService.boardUpdateComment(board);
		return commentService.commentDeleteService(cno);
		
	}
	
	
	@RequestMapping("/update/{cno}")
	@ResponseBody
	private int boardUpdateProc(@PathVariable int cno, @RequestParam String content) throws Exception{
       
		CommentVO comment = commentService.commentDetailService(cno);
		comment.setContent(content);
        
        return commentService.commentUpdateService(comment);

	}
}

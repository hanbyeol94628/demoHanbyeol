package com.example.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.domain.CommentVO;
import com.example.mapper.CommentMapper;

@Service("com.example.service.CommentService")
public class CommentService {

	@Resource(name="com.example.mapper.CommentMapper")
	CommentMapper commentMapper;
	
	public List<CommentVO> commentListService() throws Exception{
		return commentMapper.commentList();
	}
	
	public int commentInsertService(CommentVO comment) throws Exception{
		return commentMapper.commentInsert(comment);
	}
	
	public int commentUpdateService(CommentVO comment) throws Exception{
		return commentMapper.commentUpdate(comment);
	}
	
	public int commentDeleteService(int cno) throws Exception{
		return commentMapper.commentDelete(cno);
	}
	
}

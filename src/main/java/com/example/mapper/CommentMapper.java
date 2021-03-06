package com.example.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domain.CommentVO;

@Repository("com.example.mapper.CommentMapper")
public interface CommentMapper {

	// 댓글 수
	public int commentCount(int no) throws Exception;
	
	// 댓글 목록
	public List<CommentVO> commentList(int no) throws Exception;
	
	// 댓글 작성
	public int commentInsert(CommentVO comment) throws Exception;
	
	// 댓글 수정
	public int commentUpdate(CommentVO comment) throws Exception;
	
	// 댓글 삭제
	public int commentDelete(int cno) throws Exception;
	
	// 댓글 상세
	public CommentVO commentDetail(int cno) throws Exception;

}

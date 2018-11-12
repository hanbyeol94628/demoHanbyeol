package com.example.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domain.BoardVO;

@Repository("com.example.mapper.BoardMapper")
public interface BoardMapper {
	
	// 글 개수
	public int boardCount() throws Exception;

	// 글 목록
	public List<BoardVO> boardList() throws Exception;
	
	// 글 보기 (하나씩)
	public BoardVO boardDetail(int no) throws Exception;
	
	// 글 쓰기
	public void boardInsert(BoardVO board) throws Exception;
	
	// 글 수정
	public void boardUpdate(BoardVO board) throws Exception;
	
	// 글 삭제
	public void boardDelete(int no) throws Exception;
	
	
	
}

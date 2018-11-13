package com.example.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domain.BoardVO;
import com.example.domain.FileVO;

@Repository("com.example.mapper.BoardMapper")
public interface BoardMapper {
	
	// 글 개수
	public int boardCount() throws Exception;
	
	// 글 목록
	public List<BoardVO> boardList() throws Exception;
	
	// 글 보기 (하나씩)
	public BoardVO boardDetail(int no) throws Exception;
	
	// 글 쓰기
	public int boardInsert(BoardVO board) throws Exception;
	
	// 글 수정
	public int boardUpdate(BoardVO board) throws Exception;
	
	// 글 삭제
	public int boardDelete(int no) throws Exception;
	
	// 파일 업로드
	public int fileInsert(FileVO file) throws Exception;

	// 마지막 글번호
	public int lastNo() throws Exception;
}

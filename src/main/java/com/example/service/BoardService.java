package com.example.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.domain.BoardVO;
import com.example.mapper.BoardMapper;

@Service("com.example.service.BoardService")
public class BoardService {
	
	@Resource(name="com.example.mapper.BoardMapper")
	BoardMapper boardMapper;
	
	public List<BoardVO> boardListService() throws Exception{
		return boardMapper.boardList();
	}
	
	public BoardVO boardDetailService(int no) throws Exception{
		return boardMapper.boardDetail(no);
	}
	
	public int boardInsertService(BoardVO board) throws Exception{
		return boardMapper.boardInsert(board);
	}
	
	public int boardUpdateService(BoardVO board) throws Exception{
		return boardMapper.boardUpdate(board);
	}
	
	public int boardDeleteService(int no) throws Exception{
		return boardMapper.boardDelete(no);
	}
	
}

package com.example.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
		
		MultipartFile files = null;
		
		String sourceFileName = files.getOriginalFilename();
		String sourcFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
		String fileUrl = "F:\\JSP_study\\demoHanbyeol\\src\\main\\webapp\\WEB-INF\\uploadFiles";
		
		do {
			destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourcFileNameExtension;
			destinationFile = new File(fileUrl + destinationFileName);
		} while(destinationFile.exists());
		
		destinationFile.getParentFile().mkdirs();
		files.transferTo(destinationFile);
		
		boardService.boardInsertService(board);
		
		return "redirect:/list";
	}
	
	
	// 수정 폼 호출
	@RequestMapping("/update/{no}") 
	private String boardUpdateForm(@PathVariable int no, Model model) throws Exception{
		model.addAttribute("detail", boardService.boardDetailService(no));
		return "update";
	}
	
	@RequestMapping("/updateProc/{no}")
	private String boardUpdateProc(@PathVariable int no, Model model, HttpServletRequest request) throws Exception{
       
		BoardVO board = boardService.boardDetailService(no);
        board.setSubject(request.getParameter("subject"));
        board.setContent(request.getParameter("content"));
        boardService.boardUpdateService(board);
        
        return "redirect:/detail/"+request.getParameter("no"); 

	}
	
	
	// 삭제 
	@RequestMapping("/delete/{no}")
	private String boardDelete(@PathVariable int no) throws Exception{
		boardService.boardDeleteService(no);
		return "redirect:/list";
	}
	
	
}

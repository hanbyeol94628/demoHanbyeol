package com.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.BoardVO;
import com.example.domain.FileVO;
import com.example.service.BoardService;

@Controller
public class BoardController {

	@Value("${file.upload.directory}")
	String uploadFileDir;
	
	@Resource(name="com.example.service.BoardService")
	BoardService boardService;
	
	
	// 리스트
	@RequestMapping(value= {"/list", "/"})
	private String boardList(Model model) throws Exception{
		model.addAttribute("list", boardService.boardListService());
		return "list";
	}
	
	@RequestMapping("/detail/{no}")
	private String boardDetail(@PathVariable int no, Model model) throws Exception{
		model.addAttribute("detail", boardService.boardDetailService(no));
		model.addAttribute("files", boardService.fileDetailService(no));
		return "detail";
	}
	
	// 작성 폼 호출
	@RequestMapping("/insert")
	private String boardInsertForm() throws Exception {
		return "insert";
	}
	
	
	@RequestMapping("/insertProc")
	private String boardInsertProc(HttpServletRequest request, @RequestParam("files") MultipartFile files) throws Exception{

		BoardVO board = new BoardVO();
		FileVO file = new FileVO();
		
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));
		

		if(files.isEmpty()) {
			boardService.boardInsertService(board);
		}else {
			
			String fileName = files.getOriginalFilename();
			String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
			File destinationFile;
			String destinationFileName;
//			String fileUrl = "F:\\JSP_study\\demoHanbyeol\\src\\main\\webapp\\WEB-INF\\uploadFiles\\";
			
			do {
				destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
				destinationFile = new File(uploadFileDir + destinationFileName);
			} while(destinationFile.exists());
			
			destinationFile.getParentFile().mkdirs();
			files.transferTo(destinationFile);
			
			boardService.boardInsertService(board);
			
			file.setNo(boardService.lastNo());
			file.setFileName(destinationFileName);
			file.setFileOrigName(fileName);
			file.setFileUrl(uploadFileDir);

			boardService.fileInsertService(file);
		}
		
		return "redirect:/list";
	}
	
	
	
	
	// 파일 다운로드
	@RequestMapping("/fileDown/{no}")
	private void fileDown(@PathVariable int no, HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		req.setCharacterEncoding("utf-8");
		FileVO fileVO = boardService.fileDetailService(no);
		
		// 파일 업로드 경로
		try {
			String fileUrl = fileVO.getFileUrl();
			fileUrl += "/";
			String savePath = fileUrl;
			String fileName = fileVO.getFileName();
			
			// 실제 내보낼 파일명
			String origFileName = fileVO.getFileOrigName();
			InputStream in = null;
			OutputStream out = null;
			File file = null;
			boolean skip = false;
			String client = "";
			
			// 파일 읽어서 스트림에 담기
			try {
				file = new File(savePath, fileName);
				in = new FileInputStream(file);
			}catch (FileNotFoundException e) {
				skip = true;
			}
			
			client = req.getHeader("User-Agent");
			
			// 파일 다운로드 헤더 지정
			res.reset();
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Description", "JSP Generated Data");
			
			if(!skip) {
				// IE
				if(client.indexOf("MSIE")!=-1) {
					res.setHeader("Content-Disposition", "attachment; filename=\""
							+ java.net.URLEncoder.encode(origFileName, "utf-8").replaceAll("\\+", "\\ ") + "\"");
				}
				// IE 11 이상
				else if (client.indexOf("Trident")!= -1) {
					res.setHeader("Content-Disposition", "attachment; filename=\""
							+ java.net.URLEncoder.encode(origFileName, "utf-8").replaceAll("\\+", "\\ ") + "\"");
				} else {
					// 한글 파일 처리
					res.setHeader("Content-Disposition", "attachment; filename=\"" + new String(origFileName.getBytes("utf-8"), "ISO8859_1") + "\"");
					res.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
				}
				res.setHeader("Content-Length", ""+file.length());
				out = res.getOutputStream();
				byte b[] = new byte[(int) file.length()];
				int leng = 0;
				while ((leng = in.read(b)) > 0) {
					out.write(b, 0, leng);
				}
			} else {
				res.setContentType("text/html;charset=UTF-8");
				System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다.');history.back();</script>");
			}
			in.close();
			out.close();
		}catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}
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

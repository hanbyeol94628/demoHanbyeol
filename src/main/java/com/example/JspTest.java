package com.example;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mapper.BoardMapper;

@Controller
public class JspTest {

	@Resource(name="com.example.mapper.BoardMapper")
	BoardMapper boardMapper;
	
	@RequestMapping("/test")
	private String JspTest() {
		
		try {
			System.out.println(boardMapper.boardCount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "test";
	}
}

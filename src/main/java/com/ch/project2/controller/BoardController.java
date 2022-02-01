package com.ch.project2.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.project2.model.Board;
import com.ch.project2.model.Category;
import com.ch.project2.model.Parti;
import com.ch.project2.service.BoardService;
import com.ch.project2.service.PartiService;
import com.ch.project2.service.RequestService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService bs;
	@Autowired
	private RequestService rs;
	@Autowired
	private PartiService ps;
	
	@RequestMapping("/insertForm")
	public String insertForm(Model model) {
		List<Category> categoryList = bs.getCategories();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		String today = sdf.format(cal.getTime());
		
		cal.add(Calendar.MONTH, 3);
		String lastday = sdf.format(cal.getTime());
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("today", today);
		model.addAttribute("lastday", lastday);
		
		return "board/insertForm";
	}
	@RequestMapping("/updateForm")
	public String udateForm (int b_no, Model model) {
		List<Category> categoryList = bs.getCategories();
		
		Board board = bs.getBoard(b_no);
		
		//글쓴이 포함 현재 참여자 구하기
		List<Parti> partiList = ps.ptList(b_no);
		int currentParti = partiList.size() + 1;
		
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("board",board);
		model.addAttribute("currentParti",currentParti);
		
		return "board/updateForm";
	}
	@RequestMapping ("/placeSearch")
	public String placeSearch() {
		return "board/placeSearch";
	}
	@RequestMapping("/detail")
	public String detail (Integer b_no, HttpSession session, Model model) {
		Board board = bs.getBoard(b_no);
		//신청자 현황 >> 현재 사용자가 신청자인지 판별하기 위해 사용
		
		//1. 로그인 하지 안은 사용자(session.getAttribute("member") == null) >> 신청버튼 안나오니 만들어주지 않아도 됨
		//2. 로그인 한 사용자  (session.getAttribute("member") != null) >> 현재 신청한 상태인지 ( request테이블에 값이 있고  accept = 'w'& cancel = 'n')
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

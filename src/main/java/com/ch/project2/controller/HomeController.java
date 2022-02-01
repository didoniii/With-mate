package com.ch.project2.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ch.project2.model.Category;
import com.ch.project2.service.BoardService;

@Controller
public class HomeController {
	@Autowired
	private BoardService bs;
	
	@RequestMapping(value="home", method = RequestMethod.GET)
	public String home(Model model) {
		List<Category> categoryList = bs.getCategories();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		String today = sdf.format(cal.getTime());
		
		cal.add(Calendar.YEAR, 1);
		String lastday = sdf.format(cal.getTime());
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("today", today);
		model.addAttribute("lastday", lastday);
		
		return "home";
	}
	@RequestMapping( value="error", method = RequestMethod.GET)
	public String error(Model model, HttpSession session, HttpServletRequest request) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		int result = -1;
		if(flashMap != null) {
			result = (Integer) flashMap.get("result");
		}
		session.invalidate();
		model.addAttribute("result", result);
		return "error";
	}

}

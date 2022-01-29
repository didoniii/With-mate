package com.ch.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.project2.dao.BoardDao;
import com.ch.project2.model.Category;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao bd;
	
	public List<Category> getCategories() {
		return bd.getCategories();
	}
}

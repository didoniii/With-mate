package com.ch.project2.service;

import java.util.List;
import java.util.Map;

import com.ch.project2.model.Board;
import com.ch.project2.model.Category;

public interface BoardService {

	List<Category> getCategories();

	Board getBoard(int b_no);

}

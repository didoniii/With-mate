package com.ch.project2.service;

import java.util.List;
import java.util.Map;

import com.ch.project2.model.Board;
import com.ch.project2.model.Category;

public interface BoardService {
	
	List<Category> getCategories();							// 카테고리 리스트

	int getBoardCount();									// 조회수 ( 우선 만들어 놓음 )
	
	int getMaxB_no();										// 최신 게시글 번호 

	int insertBoard(Board board);							// 게시글 DB에 넣기 (게시글 작성)

	Board getBoard(int b_no);								// 게시글 조회
	
	int updateBoard(Board board);							// 게시글 수정
	
	int getSearchBoardCount(Map<String, Object> param);		// 검색된 게시글 수
	
	List<Board> searchBoard(Map<String, Object> param);		// 검색된 게시글 리스트 (한 페이지 당)

	int selectTotalMyBoard(String m_id);					// 내가 작성한 게시글 수

	List<Board> selectMyBoard(Map<String, Object> param);	// 내가 작성한 게시글 리스트 (한 페이지 당)
}


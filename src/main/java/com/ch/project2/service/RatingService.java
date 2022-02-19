package com.ch.project2.service;

import java.util.List;
import java.util.Map;

import com.ch.project2.model.Rating;

public interface RatingService {
	
	List<Rating> selectMyRatings(Map<String, Object> param);	// 평가 내역 

	int selectMaxR_no();										// pk인 평가번호 구하기

	int insertRating(Rating rating);							// 평점 입력
		
	int updateRating(Rating rating);							// 평점 수정

	float selectAvgScore(String m_id);							// 평점  평균
}

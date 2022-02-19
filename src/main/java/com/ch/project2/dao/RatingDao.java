package com.ch.project2.dao;

import java.util.List;
import java.util.Map;

import com.ch.project2.model.Rating;

public interface RatingDao {

	List<Rating> selectMyRatings(Map<String, Object> param);

	int selectMaxR_no();

	int insertRating(Rating rating);

	int updateRating(Rating rating);

	float selectAvgScore(String m_id);
	
}

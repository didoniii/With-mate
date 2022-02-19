package com.ch.project2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.project2.dao.RatingDao;
import com.ch.project2.model.Rating;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingDao rd;
	
	public List<Rating> selectMyRatings(Map<String, Object> param) {
		return rd.selectMyRatings(param);
	}

	public int selectMaxR_no() {
		return rd.selectMaxR_no();
	}

	public int insertRating(Rating rating) {
		return rd.insertRating(rating);
	}

	public int updateRating(Rating rating) {
		return rd.updateRating(rating);
	}

	public float selectAvgScore(String m_id) {
		return rd.selectAvgScore(m_id);
	}
}

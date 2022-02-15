package com.ch.project2.dao;

import java.util.List;
import java.util.Map;

import com.ch.project2.model.Request;

public interface RequestDao {

	List<Request> rqList(int b_no);

	Request select(Map<String, Object> request);

	int insert(Map<String, Object> request);

	int update(Map<String, Object> request);

	int accept(Map<String, Object> accept);

	int insertParti(Map<String, Object> accept);

	int reject(Map<String, Object> reject);

	int cancel(Map<String, Object> cancel);

	Request selectRequest(Map<String, Object> request);

	void rejectAll(int b_no);

	int selectTotalMyRequest(String m_id);

	List<Request> selectMyRequest(Map<String, Object> param);
	
}

package com.ch.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.project2.dao.PartiDao;
import com.ch.project2.model.Parti;

@Service
public class PartiServiceImpl implements PartiService {
	@Autowired
	private PartiDao pd;
	
	public List<Parti> ptList(int b_no) {
		return pd.ptList(b_no);
	}
	
}
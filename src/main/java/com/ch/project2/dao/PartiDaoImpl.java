package com.ch.project2.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.project2.model.Parti;

@Repository
public class PartiDaoImpl implements PartiDao {
	@Autowired
	private SqlSessionTemplate sst;
	
	public List<Parti> ptList(int b_no) {
		return sst.selectList("partins.ptList", b_no);
	}
}

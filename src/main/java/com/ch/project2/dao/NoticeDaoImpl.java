package com.ch.project2.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.project2.model.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	@Autowired
	private SqlSessionTemplate sst;
	
	public int selectTotalNotice() {
		return sst.selectOne("noticens.selectTotalNotice");
	}
	public List<Notice> selectNoticeList(Map<String, Object> param) {
		return sst.selectList("noticens.selectNoticeList", param);
	}
	public int selectNoticeNum() {
		return sst.selectOne("noticens.selectNoticeNum");
	}
	public int insertNotice(Notice notice) {
		return sst.insert("noticens.insertNotice", notice);
	}
	public Notice selectNotice(int no_no) {
		return sst.selectOne("noticens.selectNotice", no_no);
	}
	public int updateNotice(Notice notice) {
		return sst.update("noticens.updateNotice", notice);
	}
}

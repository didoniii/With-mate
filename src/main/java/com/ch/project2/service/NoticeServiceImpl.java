package com.ch.project2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.project2.dao.NoticeDao;
import com.ch.project2.model.Notice;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDao nd;
	
	public int selectTotalNotice() {
		return nd.selectTotalNotice();
	}
	public List<Notice> selectNoticeList(Map<String, Object> param) {
		return nd.selectNoticeList(param);
	}
	public int selectNoticeNum() {
		return nd.selectNoticeNum();
	}
	public int insertNotice(Notice notice) {
		return nd.insertNotice(notice);
	}
	public Notice selectNotice(int no_no) {
		return nd.selectNotice(no_no);
	}
	public int updateNotice(Notice notice) {
		return nd.updateNotice(notice);
	}
}

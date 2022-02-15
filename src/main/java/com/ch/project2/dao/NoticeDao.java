package com.ch.project2.dao;

import java.util.List;
import java.util.Map;

import com.ch.project2.model.Notice;

public interface NoticeDao {

	int selectTotalNotice();

	List<Notice> selectNoticeList(Map<String, Object> param);

	int selectNoticeNum();

	int insertNotice(Notice notice);

	Notice selectNotice(int no_no);

	int updateNotice(Notice notice);

}

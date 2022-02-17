package com.ch.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.project2.dao.ReplyDao;
import com.ch.project2.model.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDao rd;
	
	
	public List<Reply> getReplyList(int b_no) {
		return rd.getReplyList(b_no);
	}

	public int insertReply(Reply reply) {
		return rd.insertReply(reply);
	}

	public int selectReplyCount() {
		return rd.selectReplyCount();
	}

	public int selectReStep(int re_ref) {
		return rd.selectReStep(re_ref);
	}

	public String selectReplyMaster(int re_ref) {
		return rd.selectReplyMaster(re_ref);
	}

	public int delete(int re_no) {
		return rd.delete(re_no);
	}
}

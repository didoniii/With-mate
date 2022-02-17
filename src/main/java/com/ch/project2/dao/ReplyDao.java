package com.ch.project2.dao;

import java.util.List;

import com.ch.project2.model.Reply;

public interface ReplyDao {

	List<Reply> getReplyList(int b_no);

	int insertReply(Reply reply);

	int selectReplyCount();

	int selectReStep(int re_ref);

	String selectReplyMaster(int re_ref);

	int delete(int re_no);

}

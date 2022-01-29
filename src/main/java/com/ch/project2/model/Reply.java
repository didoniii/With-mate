package com.ch.project2.model;

import java.sql.Date;

import lombok.Data;

//re
@Data
public class Reply {
	private int 	re_no;			// 댓글 번호
	private Integer b_no;			// 게시글 번호
	private String 	m_id;			// 작성자 아이디
	private String 	content;		// 내용
	private int 	re_ref;			// 대댓글 참조 (원 댓글 번호)
	private int 	re_step;		// 대댓글 순서
	private Date 	reg_date;		// 작성일
	private String 	secret;			// 비밀 댓글 여부
	private String 	del;			// 삭제 여부
	
	private String	re_master;		
	
	private Board 	board;
	private Member 	member;
}

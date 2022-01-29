package com.ch.project2.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {
	private Integer	b_no;        	// 게시글 번호
	private String	m_id;			// 작성자 아이디
	private int		c_no;			// 카테고리 번호
	private String 	subject;		// 제목
	private Date	s_date;			// 시작일
	private Date	e_date;			// 종료일
	private Date	e_date_after;	// 종료일 7일 이후
	private String	address;		// 모집 주소
	private String 	content;		// 내용
	private	int		m_count;		// 모집 인원
	private int		readcount;		// 조회 수
	private Date	reg_date;		// 게시글 작성일
	private String	end;			// 모집 종료
	private String	del;			// 삭제여부
	private Float	r_score;		// 해당 게시글의 내 평점 평균
	
	private Category 	category;
	private Member		member;
}

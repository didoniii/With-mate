package com.ch.project2.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Member {
	private String 	m_id;			// 아이디	
	private String 	password;		// 비밀번호
	private Date	reg_date;		// 가입일
	private String	nickname;		// 닉네임
	private Date	birthday;		// 생일
	private String 	place;			// 출몰지 (주요 활동지역)
	private String 	tag;			// 나의 태그 (관심사)
	private String	picture;		// 회원 사진
	private Float	rating;			// 평점
	private String	admin;			// 관리자 여부
	private String	del;			// 삭제 여부
	
}

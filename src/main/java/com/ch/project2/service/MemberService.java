package com.ch.project2.service;

import com.ch.project2.model.Member;

public interface MemberService {
	Member selectMember(String m_id);				// 회원 정보 조회
	
	Member selectMemberWithNick(String nickname);	// 닉네임 중복체크 
	
	int insert(Member member);						// 회원 가입
	
	int updateProfile(Member member);				// 프로필 정보 입력
	
	//멤버 정보 수정
	int updateMember(Member member);				//
			
	int updateRating(Member member);				//
}

package com.ch.project2.service;

import java.util.List;
import java.util.Map;

import com.ch.project2.model.Parti;

public interface PartiService {

	List<Parti> ptList(int b_no);							// 참여자 리스트
	
	List<Parti> ptCancelList(int b_no);						// 참여자중 신청 취소한 유저 리스트
	
	int ban(Map<String, Object> ptOut);						// 참여자 강퇴
	
	int ptCancel(Map<String, Object> ptCancel); 			// 참여자 탈퇴 신청
	
	int ptReCancel(Map<String, Object> ptReCancel);			// 참여자 탈퇴 신청 취소
	
	int pcAccess(Map<String, Object> pcAccess);				// 참여자 탈퇴 신청 수락
	
	int pcReject(Map<String, Object> pcReject);				// 참여자 탈퇴 신청 거절
	
	Parti banned(Map<String, Object> param);				// 강퇴||탈퇴 여부판단
			
	int selectTotalMyParti(String m_id);					// 내가 참여한 게시글 수
	
	List<Parti> selectMyParti(Map<String, Object> param);	// 내가 참여한 게시글 정보 + 해당 게시글의 내 평점

}

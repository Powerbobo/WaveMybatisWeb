package com.kh.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.SqlSessionTemplate;
import com.kh.member.model.dao.MemberDAO;
import com.kh.member.model.vo.Member;

public class MemberService {
	
	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
	}

	/**
	 * 
	 * @param member 데이터 추가
	 * @return
	 */
	public int insertMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.insertMember(session, member);
		if(result > 0) {
			// 성공 -> 커밋
			session.commit();
		} else {
			// 실패 -> 롤백
			session.rollback();
		}
		session.close();
		return result;
	}
	/**
	 * 
	 * @param memberId 데이터 삭제
	 * @return
	 */
	public int deleteMember(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.deleteMember(session, memberId);
		if(result > 0) {
			// 성공 -> 커밋
			session.commit();
		} else {
			// 실패 -> 롤백
			session.rollback();
		}
		session.close();
		return result;
	}
	// 데이터 수정
	public int updateMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.updateMember(session, member);
		if(result > 0) {
			// 성공 -> 커밋
			session.commit();
		} else {
			// 실패 -> 롤백
			session.rollback();
		}
		session.close();
		return result;
	}
	// 로그인
	public Member seleteCheckLogin(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mDao.seleteCheckLogin(session, member);
		session.close();
		return mOne;
	}

	public Member selectOneById(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member member = mDao.selectOneById(session,memberId);
		session.close();
		return member;
	}

}

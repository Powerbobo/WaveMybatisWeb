package com.kh.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.model.vo.Member;

public class MemberDAO {
	// 데이터 추가
	public int insertMember(SqlSession session, Member member) {
		// member-mapper.xml 에 작성한 쿼리문 가져와서 사용
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}
	// 데이터 수정
	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}
	// 데이터 삭제
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}
	// 로그인
	public Member seleteCheckLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.seleteCheckLogin", member);
		return mOne;
	}
}

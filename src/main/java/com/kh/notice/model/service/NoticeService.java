package com.kh.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.SqlSessionTemplate;
import com.kh.notice.model.dao.NoticeDAO;
import com.kh.notice.model.vo.Notice;

public class NoticeService {
	private NoticeDAO nDao;
	
	public NoticeService() {
		nDao = new NoticeDAO();
	}
	
	// 데이터 INSERT
	public int insertNotice(Notice notice) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.insertNotice(session, notice);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	// 데이터 업데이트
	public int updateNotice(Notice notice) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.updateNotice(session, notice);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public List<Notice> selectNoticeList(int currentPage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Notice> nList = nDao.selectNoticeList(session, currentPage);
		return nList;
	}
	// 데이터 상세조회
	public Notice selectOneByNo(int noticeNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Notice notice = nDao.selectOneByNo(session, noticeNo);
		session.close();
		return notice;
	}
	// 데이터 삭제
	public int deleteNotice(int noticeNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.deleteNotice(session, noticeNo);
		// 커밋 & 롤백은 DML의 경우에만 하는 것임!
		if(result > 0) {
			// 성공시 커밋
			session.commit();
		} else {
			// 실패시 롤백
			session.rollback();
		}
		// 연결해제
		session.close();
		return result;
	}

}

package com.kh.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/notice/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// SELECT * FROM NOTICE_TBL ORDER BY NOTICE_NO DESC(최신순으로 가져오기, 페이징처리는 보류)
		NoticeService service = new NoticeService();
		// 삼항 연산자 이용해서 오류 방지
		String page = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "1";
		int currentPage = Integer.parseInt(page);
		List<Notice> nList = service.selectNoticeList(currentPage);
		// nList는 없어도 널이 아니라서 isEmpt()로 비어있는지 체크
		// 비슷한 방법으로 nList.size() > 0 이 있음
		if(!nList.isEmpty()) {
			// 성공하면 list.jsp로 이동
			request.setAttribute("nList", nList);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp");
			view.forward(request, response);
		} else {
			// 실패하면 메세지 출력 후 메인으로 이동
			request.setAttribute("msg", "데이터 조회가 완료되지 않았습니다.");
			request.setAttribute("url", "/index.jsp");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

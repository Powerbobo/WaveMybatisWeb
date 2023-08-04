package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/member/myPage.do")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// a 태그여서 get 방식 사용
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");	// 쿼리스트링 = 을 기준으로 왼쪽에 있는 값
		MemberService service = new MemberService();
		// SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?
		Member member = service.selectOneById(memberId);
		if(member != null) {	// 멤버가 있으면~
			request.setAttribute("member", member);
			request.getRequestDispatcher("/WEB-INF/views/member/myPage.jsp").forward(request, response);
		} else {	// 멤버가 없으면~
			request.setAttribute("msg", "회원정보가 존재하진 않습니다");
			request.setAttribute("url", "/index.jsp");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
			view.forward(request, response);
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

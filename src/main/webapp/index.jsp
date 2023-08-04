<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>웨이브 마이바티스 웹</title>
	</head>
	<body>
		<%-- 		<jsp:include page="./header.html"></jsp:include> --%>
		<h1>웨이브 마이바티스 웹</h1>
		<c:if test="${ sessionScope.memberId ne null }">
			${memberName } 님 환영합니다.<br>
			<!-- SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? -->
			<!-- 마이페이지를 누를 때 아이디를 넘겨줘야해서 쿼리스트링으로 만들어 주어야 한다. -->
			<a href="/member/myPage.do?memberId=${memberId }">마이페이지</a> <a href="/member/logout.do?memberId=${memberId }">로그아웃</a>
		</c:if>
		<c:if test="${ sessionScope.memberId eq null }">
			<h2>로그인 페이지</h2>
			<fieldset>
				<legend>로그인</legend>
				<form action="/member/login.do" method="Post">
					<input type="text" name="member-id"><br> <input
						type="password" name="member-pw"><br> <br>
					<div>
						<input type="submit" value="로그인"> <input type="reset"
							value="취소"> <a href="/member/register.do">회원가입</a>
					</div>
				</form>
			</fieldset>
		</c:if>
	</body>
</html>
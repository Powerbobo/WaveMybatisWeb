<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>썸머 멤버 웹</title>
	</head>
	<body>
<%-- 		<jsp:include page="./header.html"></jsp:include> --%>
		로그인이 성공하였으면 보여요 : ${sessionScope.memberId }
		<h1>썸머 멤버 웹!</h1>
		<h2>로그인 페이지</h2>
<%-- 			${sessionScope.memberName}님 환영합니다! <a href="/member/logout.do">로그아웃</a> --%>
<%-- 			<a href="/member/myInfo.do?member-id=${memberId}">마이페이지</a> --%>
			<fieldset>
				<legend>로그인</legend>
				<form action="/member/login.do" method="Post">
					<input type="text" name="member-id"><br> <input
						type="password" name="member-pw"><br>
					<br>
					<div>
						<input type="submit" value="로그인"> 
						<input type="reset"value="취소">
						<a href="/member/register.do">회원가입</a>
					</div>
				</form>
			</fieldset>
	</body>
</html>
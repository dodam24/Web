<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
String name = session.getAttribute("memName"); --%>
<h3>${sessionScope.memName }님 로그인</h3>
<br>
<input type="button" value="로그아웃" onclick="location.href='/mvcMember/member/logout.do'">
<input type="button" value="회원정보수정" onclick="location.href='updateForm.jsp'">
<input type="button" value="회원탈퇴" onclick="location.href='deleteForm.jsp'">	
</body>
</html>
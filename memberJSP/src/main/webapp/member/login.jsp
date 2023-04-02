<%@ page import="member.dao.MemberDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	//데이터
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	String name = memberDAO.memberLogin(id, pwd);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(name == null) {
	//페이지 이동
	response.sendRedirect("loginFail.jsp");
	
}else { 
	//쿠키
	/*
	Cookie cookie = new Cookie("memName", name);
	cookie.setMaxAge(30 * 60); //초 단위 - 30분
	response.addCookie(cookie); //클라이언트에 보내기
	
	Cookie cookie2 = new Cookie("memId", id);
	cookie2.setMaxAge(30 * 60); //초 단위
	response.addCookie(cookie2); //클라이언트에 보내기
	*/ 
	
	//세션 (쿠키보다 세션을 더 많이 이용)
	//HttpSession session = request.getSession(); //JSP는 세션이 이미 내장객체로 존재하므로, session을 또 생성할 필요 없음
	session.setAttribute("memName", name);
	session.setAttribute("memId", id);
	session.setAttribute("memPwd", pwd);
	
	//페이지 이동
	response.sendRedirect("loginOk.jsp");
} %>
</body>
</html>
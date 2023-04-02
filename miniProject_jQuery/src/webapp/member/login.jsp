<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="member.bean.MemberDTO"%>
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
	
	Map<String, String> map = new HashMap<String, String>();
	map.put("id", id);
	map.put("pwd", pwd);
	MemberDTO memberDTO = memberDAO.memberLogin(map);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(memberDTO == null) {
	//페이지 이동(로그인 실패)
	response.sendRedirect("loginFail.jsp");
	
}else { 
	//세션 생성
	//HttpSession session = request.getSession(); //JSP는 세션이 이미 내장객체로 존재하므로, session을 또 생성할 필요 없음
	session.setAttribute("memName", memberDTO.getName());
	session.setAttribute("memId", id);
	session.setAttribute("memPwd", pwd);
	
	//페이지 이동(로그인 성공)
	response.sendRedirect("loginOk.jsp");
} %>
</body>
</html>
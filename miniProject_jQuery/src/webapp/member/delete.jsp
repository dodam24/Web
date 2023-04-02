<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO" %>

<% 
	//데이터 (id 정보 받아오기)
	String id = (String)session.getAttribute("memId"); //object이므로 형변환 해줄 것!

	//세션
	//session.removeAttribute("memName");
	//session.removeAttribute("memId");
	session.invalidate(); //모든 세션을 무효화
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	memberDAO.memberDelete(id); //pwd가 진짜 있는지 체크 (true, false 체크할 때 is로 체크함)

%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
window.onload=function(){
	alert("회원탈퇴 완료!!");
	location.href = "loginForm.jsp";
}
</script>
</body>
</html>
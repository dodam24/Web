<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<title>Insert title here</title>
div {
	color : red;
	font-size : 8pt;
	font-weight : bold;
}
</style>
</head>
<body>
<h3>
<img src="../image/img.jpeg" width="50" height="50" alt="라인" 
onclick="location.href='../index.jsp'" style="cursor: pointer;">로그인
</h3>
<form name="loginForm" method="post" action="/mvcMember/member/login.do">
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="id" id="id" size="30" placeholder="아이디 입력">
			<div id="idDiv"></div>
		</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" name="pwd" id="pwd" size="40">
			<div id="pwdDiv"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: center;">
			<input type="button" value="로그인" onclick="checkLogin()">
			<input type="button" value="회원가입" onclick="location.href='/mvcMember/member/writeForm.do'">
		</td>
	</tr>
</table>
</form>
<script type="text/javascript" src="../js/login.js"></script>
</body>
</html>
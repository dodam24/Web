<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO" %>
  
<% 
	//데이터 (id 정보 받아오기)
	String pwd = request.getParameter("pwd"); //넘어온 데이터
	System.out.println("pwd = " + pwd); //맨 처음에는 pwd가 null (검색 버튼 누르기 전)
	
	//세션
	String id = (String)session.getAttribute("memId"); //세션의 id값 가져오기
	String memPwd = (String)session.getAttribute("memPwd"); //세션의 pwd값 가져오기
	
	//DB
	boolean exist = false;
	if(pwd != null){
		//MemberDAO memberDAO = MemberDAO.getInstance();
		//exist = memberDAO.isExistPwd(id, pwd); //비밀번호가 있으면 true, 없으면 false
		
		if(memPwd.equals(pwd)) exist = true; //비밀번호 세션 이용
	}
	
	if(exist) response.sendRedirect("delete.jsp");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#pwdDiv {
	color: red;
	font-weight: bold;
	font-size: 8pt;	
}
</style>
</head>
<body>
<form name="deleteForm" method="post" action="deleteForm.jsp"> <!-- 데이터 넘어갈 때, 안 보이게 하려면 post 방식 이용 -->
<table>
	<tr>
		<th>비밀번호 입력 : </th>
		<td>
			<input type="password" name="pwd" id="pwd">
			<input type="button" value="검색" onclick="checkPwd()"> <!-- 유효성 검사 하려면 button으로 만들기 -->
			<br><br>
			<div id="pwdDiv">
				<%if(pwd != null && !exist) { %>
					비밀번호가 맞지 않습니다.
				<%} %>
			</div>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">

function checkPwd(){
	document.getElementById("pwdDiv").innerText = ""; <!-- 초기화 --> 
	
	if(document.getElementById("pwd").value == "") 
		document.getElementById("pwdDiv").innerText == "비밀번호를 입력하세요";
	else
		document.deleteForm.submit();
}
</script>
</body>
</html>
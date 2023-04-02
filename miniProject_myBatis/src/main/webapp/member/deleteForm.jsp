<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	//데이터
	String pwd = request.getParameter("pwd");
	System.out.println("pwd = " + pwd); //맨 처음에는 pwd가 null (검색 버튼 누르기 전)
	
	//세션
	String id = (String)session.getAttribute("memId"); //세션의 id값 가져오기
	String memPwd = (String)session.getAttribute("memPwd");
	
	//DB (비밀번호는 위에 session 이용하는 방법과 DB 갔다오는 방법 2가지 존재)
	boolean exist = false;
	if(pwd != null){
		// MemberDAO memberDAO = MemberDAO.getInstance();
		// exist = memberDAO.isExistPwd(id, pwd);
		if(memPwd.equals(pwd)) exist = true;
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
<form name="deleteForm" method="post" action="deleteForm.jsp"> <!-- 데이터 넘어갈 때 안 보이게 하려면 get 방식 이용 -->
<table>
	<tr>
		<th>비밀번호 입력 : </th>
		<td>
			<input type="password" name="pwd" id="pwd">
			<input type="button" value="검색" onclick="checkPwd()"> <!-- 유효성 검사 하려면 button 생성 -->
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
	document.getElementById("pwdDiv").innerText = "";

	if(document.getElementById("pwd").value == "")
		document.getElementById("pwdDiv").innerText == "비밀번호를 입력하시오";
	else
		document.deleteForm.submit();
}
</script>
</body>
</html>
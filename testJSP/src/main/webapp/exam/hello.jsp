<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!		
	//선언문: 변수나 메소드를 정의하는 영역
	//전역변수, 1번만 실행
	String name = "홍길동";
	int age = 25;
%>

<%
	//스크립트릿(scriptlet): 모든 자바 코드를 사용할 수 있는 영역
	//지역변수, 호출 할 때마다 실행
	age++;
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- hello JSP!!<br> : HTML 주석 -->

<%-- 안녕하세요 JSP!!<br> : JSP 주석 --%>

나의 이름은 <%=name %>입니다.<br>
<% out.println("나의 이름은 " + name + "입니다."); %> <!-- 선호하는 방법은 아님 -->

<!-- 내 나이는 <%=age %>살 입니다.<br> -->
<%-- 내 나이는 <%=age %>살 입니다.<br> --%>

</body>
</html>
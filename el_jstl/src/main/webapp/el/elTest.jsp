<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="50%">
	<tr>
		<th width="50%">표현식</th>
		<th>값</th>
	</tr>
	
	<tr>
		<td align="center">\${25+3 }</td> <!-- 앞에 \ 붙이면 태그 그대로 출력 -->
		<td align="center">${25+3 }</td>
	</tr>
	
	<tr>
		<td align="center">\${25/3 }</td>
		<td align="center">${25/3 }</td>
	</tr>
	
	<tr>
		<td align="center">\${25 div 3 }</td>
		<td align="center">${25 div 3 }</td> <!-- /는 div와 동일 -->
	</tr>
	
	<tr>
		<td align="center">\${25%3 }</td>
		<td align="center">${25%3 }</td>
	</tr>
	
	<tr>
		<td align="center">\${25 mod 3 }</td>
		<td align="center">${25 mod 3 }</td>
	</tr>
	
	<tr>
		<td align="center">\${25 < 3 }</td>
		<td align="center">${25 < 3 }</td>
	</tr>
	
	<!-- > gt, < lt, >= ge, <= le, == eq, != ne -->
	<tr>
		<td align="center">\${25 ne 3 }</td>
		<td align="center">${25 ne 3 }</td>
	</tr>
	
	<tr>
		<td align="center">\${header['host'] }</td> <!-- header를 통해 현재 서버를 알 수 있음 -->
		<td align="center">${header['host'] }</td>
	</tr>
	
	<tr>
		<td align="center">\${header.host }</td>
		<td align="center">${header.host }</td>
	</tr>
</table>
</body>
</html>
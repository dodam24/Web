<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="from" method="get" action="result.jsp">
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th>X</th>
		<td><input type="text" name="x" width="70"></td>
	</tr>
	<tr>
		<th>Y</th>
		<td><input type="text" name="y" width="70"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" name="submit" value="SUBMIT">
			<input type="reset" name="reset" value="RESET">
		</td>
	</tr>
</table>
</form>
</body>
</html>
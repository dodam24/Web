<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
	font-size: 8pt;
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
<form name="boardWriteForm" method="post" action="boardWrite.jsp">
	<h3>
		<img src="../image/img.jpeg" width="50" height="50" alt="라인"
		onclick="location.href='../index.jsp'" style="cursor: pointer;">글쓰기
	</h3>
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th>제목</th>
		<td>
			<input type="text" name="subject" id="subject" size="50">
			<div id="subjectDiv"></div>
		</td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td>
			<textarea name="content" id="content" cols="50" rows="15"></textarea>
			<div id="contentDiv"></div>
		</td>
	</tr>
	
	<tr>
	<td colspan="2" style="text-align: center;">
		<input type="button" name="write" value="글쓰기" onclick="checkBoardWrite()">
		<input type="reset" name="reset" value="다시작성">
	</td>
	</tr>
</table>		
</form>
<script type="text/javascript">

function checkBoardWrite(){
	
	document.getElementById("subjectDiv").innerText = "";
	document.getElementById("contentDiv").innerText = "";
	
	if(document.getElementById("subject").value == ""){
		document.getElementById("subjectDiv").innerText = "제목 입력";
		document.boardWriteForm.subject.focus();
		
	}else if(document.getElementById("content").value == ""){
		document.getElementById("contentDiv").innerText = "내용 입력";
		document.boardWriteForm.content.focus();
		
	}else
		document.boardWriteForm.submit();
}
</script>
</body>
</html>
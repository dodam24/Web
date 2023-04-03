<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#boardUpdateForm div{
	font-size: 8pt;
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
<form id="boardUpdateForm">
	<input type="text" name="seq" value="${seq }">
	
	<h3>
		<img src="../image/lion.gif" width="50" height="50" alt="라이언" 
		onclick="location.href='../index.jsp'" style="cursor: pointer;"> 글수정
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
				<input type="button" value="글수정" id="boardUpdateBtn">
				<input type="reset" value="다시작성" onclick="location.reload()">
			</td> 
		</tr>
	</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_jQuery/board/getBoard.do',
		data: 'seq=' + ${seq},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#subject').val(data.subject);
			$('#content').val(data.content);
		},
		error: function(err){
			console.log(err);
		}
	});
	
	//글수정
	$('#boardUpdateBtn').click(function(){
		$('#subjectDiv').empty();
		$('#contentDiv').empty();
		
		if($('#subject').val() == ''){
			$('#subjectDiv').text('제목을 입력하세요');
			$('#subjectDiv').focus();
			
		}else if($('#content').val() == ''){
			$('#contentDiv').text('내용을 입력하세요');
			$('#content').focus();
			
		}else {
			$.ajax({
				type: 'post',
				url: '/miniProject_jQuery/board/boardUpdate.do',
				data: $('#boardUpdateForm').serialize(), //seq, subject, content
				success: function(){
					alert('글수정 완료!!');
					location.href='/miniProject_jQuery/board/boardList.do?pg=${requestScope.pg}';
				},
				error: function(err){
					console.log(err);
				}
			});
		}

	});
});
</script>
</body>
</html>
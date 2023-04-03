<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_jQuery/board/boardDelete.do',
		data: 'seq=' + ${seq},
		success: function(){
			alert('글삭제 완료!!');
			location.href='/miniProject_jQuery/board/boardList.do?pg=1';
		},
		error: function(err){
			console.log(err);
		}
	});
});
</script>
</body>
</html>
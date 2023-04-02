<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.subjectA:link { color: black; text-decoration: none; }
.subjectA:visited { color: black; text-decoration: none; }
.subjectA:hover { color: green; text-decoration: underline; }
.subjectA:active { color: black; text-decoration: none; }
#currentPaging{
	color: red;
	border: 1px solid red;
	padding: 5px 8px; /* top & bottom, left & right */
	margin: 5px; /* top, right, bottom, left */
	cursor: pointer;
}
#paging{
	color: black;
	padding: 5px;
	margin: 5px;
	cursor: pointer;
	/* border: 1px solid black; */
}
</style>
</head>
<body>
<h3>
<img src="../image/img.jpeg" width="50" height="50" alt="라인" 
onclick="location.href='../index.jsp'" style="cursor: pointer;">로그인
</h3>
<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="150">작성자</th>
		<th width="100">조회수</th>
		<th width="150">작성일</th>
	</tr>
	
	<c:if test="${requestScope.list != null}">
		<c:forEach var="boardDTO" items="${list }">
			<tr>
				<td align="center">${boardDTO.seq }</td>
				<td>
					<a class="subjectA" href="#">${boardDTO.subject }</a>
				</td>
				<td align="center">${boardDTO.id }</td>
				<td align="center">${boardDTO.hit }</td>
				<td align="center">
					<fmt:formatDate value="${boardDTO.logtime }" pattern="yyyy.MM.dd"/>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<div style="margin-top: 15px; width: 850px; text-align: center;">
	${boardPaging.pagingHTML }
</div>

<script type="text/javascript">
function boardPaging(pg){
	location.href="boardList.jsp?pg=" + pg;
}
</script>
</body>
</html>
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_jQuery/board/getBoard.do',
		data: 'seq=' + $('#seq').val(), // {'seq' : $('#seq').val()}
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
		
			$('#subjectSpan').text(data.subject);
			$('#seqSpan').text(data.seq);
			$('#idSpan').text(data.id);
			$('#hitSpan').text(data.hit);
			$('#contentSpan').text(data.content);
			
			//자신의 글?
			if($('#memId').val() == data.id)
				$('#boardViewSpan').show();
			else
				$('#boardViewSpan').hide();
		},
		error: function(err) {
        	console.log(err);
      	}
	});
});

//글수정 폼
$('#boardUpdateFormBtn').click(function(){
	$('#boardViewForm').attr('action', '/miniProject_jQuery/board/boardUpdateForm.do');
	$('#boardViewForm').submit(); //seq, pg
});

//글삭제 - 1페이지를 보여준다
$('#boardDeleteBtn').click(function(){
	$('#boardViewForm').attr('action', '/miniProject_jQuery/board/boardDeleteForm.do');
	$('#boardViewForm').submit(); //seq, pg
});

//답글쓰기 폼
$('#boardReplyFormBtn').click(function(){
	$('#boardViewForm').attr('action', '/miniProject_jQuery/board/boardReplyForm.do');
	$('#boardViewForm').submit(); //seq, pg
});
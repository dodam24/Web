//$(function(){});
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_jQuery/board/getBoardList.do',
		data: 'pg=' + $('#pg').val(), // {'pg': $('#pg').val()} 
		dataType: 'json', //서버로부터 받는 데이터의 자료형 'text', 'html', 'xml', 'json' (객체는 받을 자료형이 없다)
						  //객체를 json으로 변환시켜서 가져와야 한다.
		success: function(data){
			//console.log(JSON.stringify(data)); //객체를 JSON 문자열로 변환
			//console.log(data.list[0].seq);
			//console.log(data.list[1].name);
			
		 $.each(data.list, function(index, items){
            console.log(index + ', seq=' + items.seq + ', name=' + items.name);
            
            $('<tr/>').append($('<td/>',{
               align: 'center',
               text: items.seq
               
            })).append($('<td/>',{
	
               }).append($('<a/>',{ 
                  href: '#',
                  class: 'subjectA subjectA_'+items.seq, //클래스 속성을 여러 개 주려면 띄어쓰기 한다.
                  text: items.subject
               })) 
                   
            ).append($('<td/>',{
               align: 'center',
               text: items.id 
               
            })).append($('<td/>',{
               align: 'center',
               text: items.hit
               
            })).append($('<td/>',{
               align: 'center',
               text: items.logtime 
               
            })).appendTo($('#boardListTable')) //마지막은 .appendTo   
         	  
	     	  //답글 (이미지 앞에 답글 이미지(화살표) 넣기)
	     	  for(var i=1; i<=items.lev; i++){
				   $('.subjectA_'+items.seq).before('$emsp;');
				}
	     	  	if(items.pseq != 0){
					$('.subjectA_'+items.seq).before($('<img/>',{ //subjectA는 여러 개이므로 글번호를 지정해준다.
						'src': '/miniProject_jQuery/image/reply.gif'
					}));
				}	
	     	  
	         }); //each
			
			//페이징 처리
			$('#boardPagingDiv').html(data.pagingHTML);
			
			//로그인 여부
			$('.subjectA').click(function(){
            if($('#memId').val() == ''){
               alert('먼저 로그인하세요.');
               location.href='/miniProject_jQuery/member/loginForm.do';
            }else {
				//console.log($(this).parent().prev().prop('tagName'));
               	
               	var seq = $(this).parent().prev().text();
               	console.log(seq);
               	var pg = $('#pg').val(); //var seq = $(this).val();
               
               
               location.href = '/miniProject_jQuery/board/boardView.do?seq=' + seq + '&pg=' + pg;
            }   
         });
      },
      error: function(err) {
         console.log(err);
      }
   }); 
});
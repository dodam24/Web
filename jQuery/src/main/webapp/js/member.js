$(function(){
	$('#join').submit(function(){
		var user_id = $('input[name="user_id"]').val();
		if(!user_id){
			alert("아이디를 입력하세요.");
			$('input[name=user_id]').focus();
			return false;
		}
		
		var user_pw = $('input[name="user_pw"]').val();
		if(!user_pw){
			alert("비밀번호를 입력하세요.");
			$('input[name=user_pw]').focus();
			return false;
		}
		
		var juminno = $('input[name="juminno"]').val();
		if(!juminno){
			alert("주민번호를 입력하세요.");
			$('input[name=juminno]').focus();
			return false;
		}
		
		if( !$('input[name="gender"]').is(':checked')) { //gender값이 선택되지 않았으면
			alert("성별을 입력하세요.");
			
			//radio는 배열로 받는다.
			//document.form1.gender[1].checked = true; //자바스크립트 문법
			//$('input[name="gender"]:eq(1)').attr('checked', true); //속성을 문자열 취급
			$('input[name="gender"]:eq(1)').prop('checked', true); //속성을 값으로 취급
			return false;
		}
		
		var email = $('input[name="email"]').val();
		if(!email){
			alert("이메일을 입력하세요.");
			$('input[name=email]').focus();
			return false;
		}
		
		var url = $('input[name="url"]').val();
		if(!url){
			alert("URL을 입력하세요.");
			$('input[name=url]').focus();
			return false;
		}
		
		var hpno = $('input[name="hpno"]').val();
		if(!hpno){
			alert("핸드폰 번호를 입력하세요.");
			$('input[name=hpno]').focus();
			return false;
		}
		
		if(!$('input[name="hobby"]').is(':checked')){ //취미가 선택되지 않았으면
			alert("취미를 입력하세요");
			$('input[name="hobby"]:eq(0)').attr('checked', true);
			return false;
		}
		
		if($('selected[name="job"] > option: selected').index() < 1){ //index가 0이면 '--선택하세요--'가 선택되어 있는 상태
			alert("직업을 선택하세요.");
			$('selected[name="job"] > option:eq(1)').attr('selected', true);
			return false;
		}
		
		//입력한 내용을 화면에 출력
		var gender = $('input[name="gender"]:checked').val(); //선택한 값을 꺼내온다.
		
		//선택한 값들만 넘어온다.
		var hobby = $('input[name="hobby"]:checked'); //hobby는 여러개 선택 가능
		var hobby_val = '';
		
		hobby.each(function(){ //jQuery의 for문: each()
			//alert($(this).val()); //반복문에서 hobby안에 포함된 객체. for문을 돌면서 나오는 하나하나의 값을 this로 표현
			hobby_val += $(this).val();
		});
		
		
		var job = $('selected[name="job"] > option: selected').val();
		
		var result = '<ul>';
		result += '<li>아이디 : ' + user_id + '</li>';
		result += '<li>비밀번호 : ' + user_pw + '</li>';
		result += '<li>주민번호 : ' + juminno + '</li>';
		result += '<li>성별 : ' + gender + '</li>';
		result += '<li>이메일 : ' + email + '</li>';
		result += '<li>홈페이지 : ' + url + '</li>';
		result += '<li>핸드폰 : ' + hpno + '</li>';
		result += '<li>취미 : ' + hobby_val + '</li>';
		result += '<li>직업 : ' + job + '</li>';
		result = '<ul>';
		
		$('body').html(result); //body태그를 result로 덮어씌움
		
		return false;
	});
});
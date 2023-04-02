function checkLogin() {
	document.getElementById("idDiv").innerText = "";
	document.getElementById("pwdDiv").innerText = "";
	
	if(document.getElementById("id").value == "")
		document.getElementById("idDiv").innerText = "아이디를 입력하세요";
	else if(document.getElementById("pwd").value == "")
		document.getElementById("pwdDiv").innerText = "비밀번호를 입력하세요";
	else
		document.loginForm.submit();
}
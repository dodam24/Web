package member.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		//데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
	
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		MemberDTO memberDTO = memberDAO.memberLogin(id, pwd);
		System.out.println(memberDTO);
	
		
		//응답
		if(memberDTO == null) {
			return "/member/loginFail.jsp"; //페이지 이동(로그인 실패)
		}else {
			HttpSession session = request.getSession(); //세션 생성
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);
			session.setAttribute("memPwd", pwd);
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
				
			return "/member/loginOk.jsp"; //페이지 이동(로그인 성공)
		}
		
	}

}

package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		String subject = request.getParameter("subject"); //request와 session(SQL)을 통해 얻어오는 정보가 다름
		String content = request.getParameter("content");
		
		//세션
		//HttpSession session = request.getSession(); //JSP파일에는 session이라는 내장 객체가 존재하므로 X
		String id = "hong";
		String name = "홍길동";
		String email = "hong@naver.com";
		
		Map<String, String> map = new HashMap<String, String>();
		//나중에 map.get("id") 형으로 꺼낼 수 있음
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardWrite(map);
		
		//응답
		return "/board/boardWrite.jsp";
	}

}

package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardReplyService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		int pseq = Integer.parseInt(request.getParameter("seq")); //원글번호
		String pg = request.getParameter("pg"); //원글이 있는 페이지 번호(DB로 가는 것이 아니면 int형을 String으로 받아도 된다)
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//세션 (원글 작성자와 답글 작성자가 다르기 때문에 가져와야 함)
		HttpSession session = request.getSession(); //JSP파일에는 session이라는 내장 객체가 존재하므로 X
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
	 	String email = (String)session.getAttribute("memEmail"); //boardWrite는 세션을 get(가져오기)
		
	 	Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		map.put("pseq", pseq); //원글번호
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardReply(map);
		
		//응답
		return "/board/boardReply.jsp";
	}

}

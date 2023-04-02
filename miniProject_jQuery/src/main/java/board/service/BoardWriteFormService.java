package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardWriteFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("display", "/board/boardWriteForm.jsp");
		return "/index.jsp";
	}

}

//원글 - 무조건 1페이지로 이동 (display만 받으면 된다)
// 단, 답글은 데이터도 받아와야 한다. (원글의 번호, 원글이 있는 페이지에 대한 정보)
package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 받아오기
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); // 웹으로 갈 수 있도록 출력 스트림 생성 (new 시킨 것과 동일)
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>");
		out.println("나의 이름은 " + name + "이고 나이는 " + age + "살이므로 ");
			if(age >= 20) out.println("성인 입니다.");
			else out.println("청소년 입니다.");
		out.println("</h3>");
		out.println("</body>");
		out.println("</html>");
	}

	public void destroy() {}
}

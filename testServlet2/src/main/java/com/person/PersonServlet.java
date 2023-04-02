package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() {}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 (name 속성을 불러온다. id 속성 X)
		String name = request.getParameter("name");
		String gender = request.getParameter("gender"); 		
		String color = request.getParameter("color");
		String[] hobby = request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //웹으로 가도록 출력 스트림 생성
		out.println("<html>");
		out.println("<body style='background: yellow;'>");
		out.println("<ul style='border: 1px solid red; color: " + color + "'>");
		
		out.println("<li>이 름 : " + name);
		out.println("<br><br>");
		
		out.println("<li>성 별 : ");
		if(gender.equals("0")) out.println("남");
		else if(gender.equals("1")) out.println("여");
		out.println("<br><br>");
		
		out.println("<li>색 깔 : " + color);
		out.println("<br><br>");
		
		out.println("<li>취 미 : ");
		for(int i=0; i<hobby.length; i++) {
			out.println(hobby[i]);
		}
		out.println("<br><br>");
		
		out.println("<li>과 목 : ");
		for(String data : subject){
				out.println(data);
			}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public void destroy() {
		
	}

}

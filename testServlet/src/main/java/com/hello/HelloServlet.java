package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void init() {
		System.out.println("init()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		response.setContentType("text/html; charset=UTF-8");
		
//		1. 콘솔창에 출력 
//		System.out.println("<html>");
//		
//		2. 파일로 출력되도록 객체 생성
//		PrintWriter out = new PrintWriter(new FileWriter("result.txt"));
//		out.println("<html>");
//		
//		3. 웹 브라우저에서 출력
		PrintWriter out = response.getWriter(); // 생성
		out.println("<html>");
		out.println("<body>");
		out.println("Hello Servlet!!<br>");
		out.println("안녕하세요 서블릿!!");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	public void destroy() {
		System.out.println("destroy()");
	}

}

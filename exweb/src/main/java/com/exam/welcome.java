package com.exam;

import java.awt.Image;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹 브라우저에서 요청을 보낼때, 추가적인 정보를 전송 가능
//요청주소?파라미터명= 파라미터값
//http://localhost:8000/exweb/Param.do?apple=123456789
//서블릿에서는 요청객체.getParameter("파라미터명")명령으로 
//파라미터값을 읽어서 사용 가능

@ WebServlet("/welcome.do")

public class welcome extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//모든 파라미터의 값은 문자열!!!
		String aval = req.getParameter("user");
		System.out.println("welcome 실행됨");
		
		resp.setContentType("text/html;charset=UTF-8");
		
		
		
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");;
		//==out.println("<meta charset='UTF-8'>");; html에서 속성값은 문자열표시할시 홑따옴표도 가능하다
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+aval+"님 환영한다!</h1>");
		
		out.println("</body>");
		out.println("</html>");;
	}

}




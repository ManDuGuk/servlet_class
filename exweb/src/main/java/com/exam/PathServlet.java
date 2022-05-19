package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//서블릿 주소(경로) 지정 방법
//경로는 반드시/ 또는 *. 로 시작
//@ WebServlet("/abc/def/ghi") //경로를 파일명까지 정확하게 지정
//@ WebServlet("/abc/*") // def/뒤에는 뭐가 오던지 상관없다. //특정 디렉토리(폴더) 아래의 모든 경로 지정
//@ WebServlet("/abc/d*") // 안됨, 경로 밑에만 *
@ WebServlet("*.action") //특정 확장자로 끝나는 모든 경로 지정
public class PathServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("ByeServelt 실행됨");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1>pathservlet 실행</h1>\r\n"
				+ " <h2>안녕히\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		
	}

}

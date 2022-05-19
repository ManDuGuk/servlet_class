package com.exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//@ WebServlet("/member/addform.do")

public class MemAddFormServlet extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		RequestDispatcher rd = req.getRequestDispatcher("");
//		rd.forward(req, resp);
		
        req.getRequestDispatcher("/WEB-INF/jsp/member/MemAddForm.jsp").forward(req, resp);
	
		
		//"http://localhost:8000/web/member/list.do"로 요청을 보내면,
		//웹브라우저에서 회원목록이 출력되도록 구현
//		System.out.println("MemAddFormServlet 실행됨");
//		
//		resp.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = resp.getWriter();
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset=\"UTF-8\">");;
//		
//		out.println("<title>Insert title here</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>회원추가</h1>");
//		
//		out.println("<form action='/exweb/member/add.do' method='post'>");
//		out.println("<form action='" +req.getContextPath()+ "/member/add.do' method='post'>");
//		out.println("회원 아이디:<input type='text' name ='memId'> <br>");
//		out.println("회원 비밀번호:<input type='password' name ='memPass'> <br>");
//		out.println("회원 이름:<input type='text' name ='memName'> <br>");
//		out.println("회원 포인트:<input type='text' name ='memPoint'> <br>");
//		out.println("<input type='submit'>");
//		out.println("</form>");
//		
//		
//		out.println("</body>");
//		out.println("</html>");;
	}

}

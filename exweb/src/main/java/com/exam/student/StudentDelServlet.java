package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@ WebServlet("/student/del.do")

public class StudentDelServlet extends HttpServlet{
	
	StudentDao studentDao = StudentDaoBatis.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		req.setCharacterEncoding("UTF-8");
		
		String memId=req.getParameter("memId");
		
		int num = studentDao.delMember(memId);
		
		//resp.sendRedirect("이동할 사이트 주소"); 명령을 사용하여,
		///웹브라우저에게 특정 사이트로 이동하라는 명령을 담은 응답을 전송
		resp.sendRedirect(req.getContextPath()+"/student/list.do");

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
//		out.println("<h1>회원삭제</h1>");
//		
//		out.println(num+" 명의 회원이 삭제되었습니다.");
//		
//		out.println("</body>");
//		out.println("</html>");;
	}

}

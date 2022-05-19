package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@ WebServlet("/stu/addform.do")

public class StudentAddFormServlet extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//"http://localhost:8000/web/member/list.do"로 요청을 보내면,
		//웹브라우저에서 회원목록이 출력되도록 구현
		
		req.getRequestDispatcher("/WEB-INF/jsp/student/StuAddForm.jsp").forward(req, resp);
		 
//		System.out.println("StudentAddFormServlet 실행됨");
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
//		out.println("<h1>학생추가</h1>");
//		
////		out.println("<form action='/exweb/member/add.do' method='post'>");
//		out.println("<form action='" +req.getContextPath()+ "/stu/add.do' method='post'>");
//		out.println("학생 아이디:<input type='text' name ='memId'> <br>");
//		out.println("학생 이름<input type='text' name ='memName'> <br>");
//		out.println("학생 포인트:<input type='text' name ='memPoint'> <br>");
//		out.println("<input type='submit'>");
//		out.println("</form>");
//		
//		
//		out.println("</body>");
//		out.println("</html>");;
	}

}

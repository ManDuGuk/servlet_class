package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






@ WebServlet("/student/list.do")

public class StudentListServlet extends HttpServlet{
	
	StudentDao studentDao = StudentDaoBatis.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//"http://localhost:8000/web/member/list.do"로 요청을 보내면,
		//웹브라우저에서 회원목록이 출력되도록 구현
		//System.out.println("MemListServlet 실행됨");
		
		//요청이 올때마다
		List<StudentVo> list = studentDao.selectMemberList();
		
		req.setAttribute("stuList", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/student/StuList.jsp");
		rd.forward(req, resp);
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
//		
//		out.println("<h1>학생목록</h1>");
//		out.println("<a href='"+req.getContextPath()+"/stu/addform.do'>학생추가</a><br>");
//		
//		out.println("학생번호 : 학생이름 : 학생포인트<br>");
//		
//		for(int i=0;i<list.size();i++) {
//			StudentVo vo= list.get(i);
//			
//			out.println(vo.getMemId()+" : "+vo.getMemName()+" : "+vo.getMemPoint());
//			out.println("<a href='"+req.getContextPath()+"/stu/del.do?memId="+vo.getMemId()+"'>삭제</a>"+"<br>");
//		}
//	
//		
//		
//		
//		out.println("</body>");
//		out.println("</html>");;
	}

}

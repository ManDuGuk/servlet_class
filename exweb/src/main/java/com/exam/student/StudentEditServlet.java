package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@ WebServlet("/student/edit.do")

public class StudentEditServlet extends HttpServlet{
	
	StudentDao studentDao = StudentDaoBatis.getInstance();
	
	//서블릿의 service() 메서드:요청방식에 상관없이 실행되는 메서드
	//서블릿의 doxxx()메서드 :요청 방식이 xxx인 경우에 실행되는 메서드
	
	//addfrom 서블릿 내용 붙여넣음/////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String memId = req.getParameter("memId");
		
		StudentVo vo=studentDao.selectMember(memId);
		
		req.setAttribute("memVo", vo);
		
        req.getRequestDispatcher("/WEB-INF/jsp/student/StuEdit.jsp").forward(req, resp);

	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//포트스 방식으로 파라미터를 받는다면 항상해주는 작업이기에 해당 코드를 필터로 만들겠다.
		//req.setCharacterEncoding("UTF-8");
		
		
		StudentVo vo=new StudentVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemName(req.getParameter("memName"));
		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint")));
		int num = studentDao.updatetMember(vo);
		
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
//		out.println("<h1>회원추가</h1>");
//		
//		out.println(num+" 명의 회원이 추가되었습니다.");
//		
//		out.println("</body>");
//		out.println("</html>");;
	}

}

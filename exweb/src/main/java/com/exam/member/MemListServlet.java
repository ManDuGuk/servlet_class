package com.exam.member;

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

//과제
//1.학생목록,추가,삭제 서블릿과 JSP파일을 구현(MVC패턴)
//2.학생정보 수정 기능 추가
@WebServlet("/member/list.do")
public class MemListServlet extends HttpServlet {
	MemberDao memberDao = new MemberDaoBatis();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//"http://localhost:8000/exweb/list.do"로 요청을보내면
			//웹브라우저에 회원 목록이 출력되도록 구현
			//111
			List<MemberVo> list = memberDao.selectMemberList();
		    
			req.setAttribute("memList", list);
			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/member/MemList.jsp");
			rd.forward(req, resp);
			
//		    resp.setCharacterEncoding("UTF-8");
//		    resp.setContentType("text/html");
//			PrintWriter out = resp.getWriter();
//			
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<meta charset='UTF-8'>");
//			out.println("<title>회원목록과 가입 삭제</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<h1>회원목록</h1>");
//			out.println("<a href='"+ req.getContextPath()+"/member/addform.do'>회원추가</a><br>");
//			out.println("회원아이디 : 회원 비밀번호 : 회원이름 : 회원포인트<br>");
//			for (int i = 0; i < list.size(); i++) {
//				MemberVO vo = list.get(i);
//				out.println(vo.getMemId() +":"+ vo.getMemPass() +":"+ vo.getMemName() +":"+ vo.getMempoint());
//				out.println("<a href='"+ req.getContextPath()+"/member/del.do?memId=" + vo.getMemId() + "'>삭제</a><br>");
//			}	
//			out.println("</body>");
//			out.println("</html>");
	}

}

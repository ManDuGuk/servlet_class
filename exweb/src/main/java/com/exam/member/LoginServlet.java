package com.exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@ WebServlet("/member/login.do")

public class LoginServlet extends HttpServlet{
	
	MemberDao memberDao = MemberDaoBatis.getInstance();
	
	//서블릿의 service() 메서드:요청방식에 상관없이 실행되는 메서드
	//서블릿의 doxxx()메서드 :요청 방식이 xxx인 경우에 실행되는 메서드
	
	//addfrom 서블릿 내용 붙여넣음/////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
        req.getRequestDispatcher("/WEB-INF/jsp/member/login.jsp").forward(req, resp);

	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//포트스 방식으로 파라미터를 받는다면 항상해주는 작업이기에 해당 코드를 필터로 만들겠다.
		//req.setCharacterEncoding("UTF-8");
		
		
		MemberVo vo=new MemberVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPass(req.getParameter("memPass"));
	
		MemberVo memVo = memberDao.selectLoginMember(vo);
		
		if(memVo==null) { //로그인이 실해한 경우,다시 로그인 페이지로 이동
			//안돼 돌아가~
			resp.sendRedirect(req.getContextPath()+"/member/login.do");
		}else {//로그인이 성공한 경우
			
			//현재 요청(을 보낸사용자)가 속한 세션객체 가져오기
			HttpSession session = req.getSession();
			//로그인 성공한 사용자 정보를 세션에 loginUser라는 이름으로 저장
			session.setAttribute("loginUser", memVo);
			//회원목록 페이지로 이동
			resp.sendRedirect(req.getContextPath()+"/member/list.do");
		}
		
		
	}

}

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

//과제
//1.변경하려는 회원아이디가 로그인한 회원의 아이디와 다르다면 변경되지 않도록 구현
//2.회원정보 변경 화면에서도 ,화명의 회원이이디가 로그인한 회원의 아이디와 다르다면,이름,포인트 값 변경이 불가능하고 submit버튼도 출력되지않도록 구현

@ WebServlet("/member/edit.do")

public class MemEditServlet extends HttpServlet{
	
	MemberDao memberDao = MemberDaoBatis.getInstance();
	
	//서블릿의 service() 메서드:요청방식에 상관없이 실행되는 메서드
	//서블릿의 doxxx()메서드 :요청 방식이 xxx인 경우에 실행되는 메서드
	
	//addfrom 서블릿 내용 붙여넣음/////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String memId = req.getParameter("memId");
		
		MemberVo vo=memberDao.selectMember(memId);
		
		req.setAttribute("memVo", vo);
		
        req.getRequestDispatcher("/WEB-INF/jsp/member/MemEdit.jsp").forward(req, resp);

	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 회원아이디와 변경할 회원아이디가 다르면 
		HttpSession session =req.getSession();
		MemberVo mvo=(MemberVo)session.getAttribute("loginUser");
		if(!mvo.getMemId().equals(req.getParameter("memId"))) {
			//여기다 어떻게 할지 구현
			//여기선 오류를 일부러 발생시키기에 return을 넣을 필요가 없다.
			throw new RuntimeException("로그인한 사용자와 다른 회원 정보는 변경 불가");
			
			//예외를 발생시킬것이 아니라면
			//일단 아래쪽 코드를 진행못하게 return으로 막는 것이 중요하다.
			//return;
		}
		//----------------------------------------
		
		
		MemberVo vo=new MemberVo();
		vo.setMemId(req.getParameter("memId"));
//		vo.setMemPass(req.getParameter("memPass"));
		vo.setMemName(req.getParameter("memName"));
		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint")));
		int num = memberDao.updatetMember(vo);
		
		//resp.sendRedirect("이동할 사이트 주소"); 명령을 사용하여,
		///웹브라우저에게 특정 사이트로 이동하라는 명령을 담은 응답을 전송
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
		

	}

}

package com.exam.comm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.member.MemberVo;

//필터: 다수의 서블릿들의 실행 전후에 공통적으로 수행해야 하는 작업을 구현

//필터를 등록하는 방법
//1.-web.xml에 <filter>를 사용하여 등록
//2.@WebFilter를 적용하여 등록(어노테이션)
public class LoginFilter implements Filter{

	//로그인 검사 하지 않고 통과시킬 주소목록
	private ArrayList<String> whiteList = new ArrayList<String>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터객체가 처음 생성된후, 1회만 실행: 보통 필터 포기화 작업 구현
		
		//로그인 없이 사용가능한 경로들을 지목
		whiteList.add("/member/login.do");
		whiteList.add("/member/add.do");
	}
	
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//필터와 연결된 주소로 요청이 올때마다 1번씩 반복적으로 실행
		
	
		
		//파라미터로 넘어오는 req는 HttpServletRequest 이기 때문에 형변환을 해줘야한다.
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		//현재요청 주소(경로)를 가져온다.
		String reqUri = req.getRequestURI();
		//앞쪽의 컨텍스트패스 주소를 지우고 저장
		reqUri=reqUri.substring(req.getContextPath().length());
		
		//로그인 없이 사용가능한 경로들을 지목 해당주소들이 요청주소에 없으면 아래 코드를 실행
		//whiteList.add("/member/login.do");
		//whiteList.add("/member/add.do");
		if(whiteList.contains(reqUri)==false) {
			
			//여러 서블릿들에서 공통적으로 적용되는 작업이다. 필터로 넣어줄것이다.
			///////////////////////////////////////////////////////////////////////	
				//로그인한 사용자 정보를 가져오기
			    //로그인 서블릿에서loginUser이름으로 저장한 세션을 가져온다.
				//가져올때 형변환을 해줘야 한다. 
				HttpSession session = req.getSession();
				MemberVo vo = (MemberVo) session.getAttribute("loginUser");
				
				if(vo==null) {
					//(로그인한적 없다면)
					//loginUser가 없는경우 로그인화면으로 보낸다.
					resp.sendRedirect(req.getContextPath()+"/member/login.do");
					
					//doGet 메소드의 실행을 중단하고 리턴해라
					//이거 안해주면 아래 코드까지 다 실행한다.
					//아래 구문을 else if로 처리해주거나 return처리하면 된다.
					return;
				}
			//////////////////////////////////////////////////////////////////////
		}
			
		
		chain.doFilter(request, response);//이후 실행될 다른 필터 또는 서블릿을 실행
		
		//서블릿을 실행하고 난 다음에는 다시 필터로 돌아와서 아래코드를 실행하게 된다.
		
	}
	
	@Override
	public void destroy() {
		//필터 객체가 소멸되기 전에 1회만 실행: 보통 필터가 사용하던 자원을 정리하고 반납하는 작업 구현
		
	}

	

}

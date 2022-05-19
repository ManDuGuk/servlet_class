package com.exam;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//원래는 extends로 확장받아서 사용하는것 보다. implements로 서블릿 인터페이스를 직접구현하는게 몬조다.
//그러나 직접 처음부터 인터페이스를 다 구현 할려면 기본적으로 갖추야 하는 메소드들을 만들어야 할것이 많기때문에 
//이미 많은 메소드들이 구현되어있는 httpservlet 클래스를 상속받아서 작성하는거다.

//서블릿 클래스는 Servlet  인터페이스를 직접 구현하거나, 
//Servlet  인터페이스를 구현 해 놓은 httpServlet 클래스를 상속하여 쓴다.

//톰켓은 서블릿 주소로 요청을 받으면
//실행할 서블릿 객체(인스턴스가) 존재하는지 찾아보고,
//객체가 존재하지 않으면 객체를 생성후 init() ,service()를 실행
//객체가 존재하면 객체의 service()를 실행


//01.httpServlet 클래스 상속
public class LifeServlet extends HttpServlet{
	
	//아래의 세가지가 기본적인 서블릿을 생명주기라 할수있다.
	//서블릿 생명주기(life cycle) : 서블릿 객체가 생성부터 소멸되기 까지 자동으로 실행되는 메서드들
	@Override
	public void init() throws ServletException {
		
		//서블릿 객체가 처음 생성된 후 1회만 실행
		//보통 서블릿 작업을 위한 초기화 작업을 위하여 실행
		System.out.println("LifeServlet: init()!");
		
		//현재 서블릿의 설정정보 가져오기
		ServletConfig config = getServletConfig();
		System.out.println(config.getServletName()); //서블릿 이름
		//web.xml에 <init-param>로 설정한 서블릿 초기화 파라미터 값 읽기
		System.out.println(config.getInitParameter("id")); 
		
		
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//서블릿 주소와 일치하는 요청이 올때마다 1번씩 실행
		System.out.println("LifeServlet: service()!");
	}
	
	@Override
	public void destroy() {
		//서블릿 객체가 소멸하기 전에 1회만 실행
		//서블릿에서 사용하던 자원을 반납하는 작업을 수행
		System.out.println("LifeServlet: destroy()!");
	}

}


//02.서블릿 클래스는 Servlet  인터페이스를 직접 구현
//LifeServlet 컨트롤 1눌러서 기본 요구 메소드 들을 만들어준다.
//public class LifeServlet implements Servlet{
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public ServletConfig getServletConfig() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getServletInfo() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}
//
//

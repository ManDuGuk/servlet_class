package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//자바 웹 애플리케이션에서 데이터를 저장할 수 있는 객체
//-HttpServletRequest (요청객체) :1개의 요청을 처리하는 동안에만 유지(요청마다 새로운 요청객체 생성)
//-HttpSesstion (세션객체):클라이언트(웹브라우저)마다 1개씩 객체를 생성하여 서버가 실행중인 동안 유지된다./다른 브라우저에서 작동시 값 초기화 확인
//사용자별로 저장하고 독립적으로 유지해야 하는 데이터를 저장
//일정시간동안 요청이 없는 세센객체는 삭제 가능
//-ServletContext (서블릿컨텍스트):웹 어플리케이션 전체에 1개만 존재 (서버 종료시까지 유지)/다른브라우저에서 작동시 값 유지 확인
//모든 사용자가 공유하는 데이터를 저장

@ WebServlet("/attr.do")


public class AttrServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int cnt= 0;
		cnt++;
		
		//1.요청객체
		//요청객체에 "cnt"라는 이름으로 저장되어 있는 속성값 읽어오기
		AtomicInteger reqCnt = (AtomicInteger) req.getAttribute("cnt");
		if(reqCnt==null) { //저장되어있는 값이 없는 경우
			reqCnt = new AtomicInteger(0); // 0을 저장한 정수객체 생성	
		}
		reqCnt.incrementAndGet();// 정수객체의 값을 1증가
		//요청객체에 "cnt"라느 이름으로 정수값을 저장
		req.setAttribute("cnt", reqCnt);
		
		
		//2.세션객체
		HttpSession session = req.getSession(); //현재 요청이 속한 세션 가져오기
		//세션객체에 "cnt"라는 이름으로 저장되어 있응 속성값 읽어오기
		AtomicInteger ssCnt = (AtomicInteger) session.getAttribute("cnt");
		if(ssCnt==null) {
			ssCnt = new AtomicInteger(0); 
		}
		ssCnt.incrementAndGet();
		//세견 객체에 "cnt"라느 이름으로 정수값을 저장
		session.setAttribute("cnt", ssCnt);
		
		//3.서블릿 컨택스트
		ServletContext context = req.getServletContext(); //현재 요청이 속한 세션 가져오기
		//세션객체에 "cnt"라는 이름으로 저장되어 있응 속성값 읽어오기
		AtomicInteger scCnt = (AtomicInteger) context.getAttribute("cnt");
		if(scCnt==null) {
			scCnt = new AtomicInteger(0); 
		}
		scCnt.incrementAndGet();
		//세견 객체에 "cnt"라느 이름으로 정수값을 저장
		context.setAttribute("cnt", scCnt);

		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");;
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>cnt: "+cnt+"</h1>");
		out.println("<h1>요청객체 cnt: "+reqCnt+"</h1>");
		out.println("<h1>세센객체 cnt: "+ssCnt+"</h1>");
		out.println("<h1>서블릿 컨텍스트객체 cnt: "+scCnt+"</h1>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}

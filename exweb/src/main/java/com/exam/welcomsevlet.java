

package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcom.do")
public class welcomsevlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		get방식으로 전송된 한글 파라미터 값 인코딩 설정
//		톰켓 설정 파일 server.xml에서 
//		URIEncoding="utf-8" 설정
//		<Connector URIEncoding="utf-8" port="8000"/>
//		톰켓8버전 부터 "utf-8"이 디폴트 값이므로 생략가능
		
//		post방식으로 전송된 한글 파라미터 값 인코딩 설정
//		파라미터값을 읽기 전에 , 요청 객체의 문자인코딩방식을 설정
//		
//		///////////////////////////이것도 물어보기//
//		제출을 한글을 입력하면,
//		제출값을 영어로 입력해도 
//		파라미터값은 숫자로 넘겨지지 않나?
//		무슨차이가 이런구문을 필요하게 만들었나?
		//넘겨진 파라미터값을 받았을때 파라미터입력을 한글로 했다면??
		req.setCharacterEncoding("UTF-8");
//		Overrides the name of the character encoding used in the body of thisrequest. 
//		문자열이 입력되어지는 방식을 해당함수의 몸체에 입력된 형식으로 만듬니다
//		This method must be called prior to 
//		reading request parametersor 
//		reading input using getReader().
//		Otherwise, it has no effect.
		String aval = req.getParameter("user");
		//user로 받아온 파라미터 값
		
		//한글을 쳐도 html상 출력되게 하는 코드가-
		resp.setCharacterEncoding("UTF-8");
//		Overrides the name of the character encoding used in the body of thisrequest. 
//		This method must be called prior to 
//		reading request parametersor 
//		reading input using getReader().
//		Otherwise, it has no effect.
		resp.setContentType("text/html");
//		== resp.setContentType("text/html;charset=UTF-8");
		
		
		
		System.out.println("welcome 실행됨");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");;
		//==out.println("<meta charset='UTF-8'>");; html에서 속성값은 문자열표시할시 홑따옴표도 가능하다
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+aval+"님 환영한다!</h1>");
		
		out.println("</body>");
		out.println("</html>");;
	}
	

}

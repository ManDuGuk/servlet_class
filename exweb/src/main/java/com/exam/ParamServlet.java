package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹 브라우저에서 요청을 보낼때, 추가적인 정보를 전송 가능
//요청주소?파라미터명= 파라미터값
//http://localhost:8000/exweb/Param.do?apple=123456789
//서블릿에서는 요청객체.getParameter("파라미터명")명령으로 
//파라미터값을 읽어서 사용 가능

@ WebServlet("/Param.do")

public class ParamServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//**************************
		//모든 파라미터의 값은 문자열!!!
		//**************************
		req.setCharacterEncoding("UTF-8");
		String aval = req.getParameter("apple");
		System.out.println("Param 실행됨");
		
		//req.getParameterValues("b");//파라미터 값이 한개일때
		String[] bvals = req.getParameterValues("b");//파라미터 값이 여러개일때
		//파라미터를 아예안보내면 배열값이 널값이 나버리고 오류가 나게된다. 
		
		resp.setContentType("text/html;charset=UTF-8");
		
		
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");;
		//==out.println("<meta charset='UTF-8'>");; html에서 속성값은 문자열표시할시 홑따옴표도 가능하다
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>파라미터 테스트</h1>");
		out.println("<h1>"+aval+"</h1>");
		
		//내풀이
		//bvals배열에 들어있는 모든 값들을 하나씩 꺼내서 출력
		//입력한 횟수를 카운트
		//그 카운트 횟수를 for문으로 돌린다.
//		int count=0;
//		while(true)
//		{
//			if(bvals!=null)
//				count++;
//			
//		}
		//bvals 배열에 들었는 모든 값을 출력
		//개쩌는 풀이다.
//		for(int i=0;i<bvals.length;i++) {
//			out.println("<h1>"+bvals[i]+"</h1>");
//		}
		
		//오류방지를 위한 코드
		if(bvals!=null) { //파라미터값이 1개이상 존재하는 경우에만
			for(int i=0;i<bvals.length;i++) {
				out.println("<h1>"+bvals[i]+"</h1>");
			}
		}
		
		
		out.println("</body>");
		out.println("</html>");;
	}

}

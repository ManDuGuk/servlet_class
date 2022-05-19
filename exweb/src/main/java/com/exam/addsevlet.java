//요청주소?파라미터명= 파라미터값&파라미터명= 파라미터값
//http://localhost:8000/exweb/Param.do?add.do?x=123&y=456
//123+456 =579



package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add.do")
public class addsevlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		System.out.println("add sevlet 실행됨");
		String x = req.getParameter("x");
		String y = req.getParameter("y");
		String z = req.getParameter("z");	
		String opv= req.getParameter("op");
		
		//int intx = req.getParameter(x);
		//int inty = req.getParameter(y);
		PrintWriter out = resp.getWriter();
	

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");;
		//==out.println("<meta charset='UTF-8'>");; html에서 속성값은 문자열표시할시 홑따옴표도 가능하다
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("add.od 내용출력");
		out.println("<h1>");
		out.println("x의 파라미터값 = "+Integer.parseInt(x));
		out.println("<br>");
		out.println("y의 파라미터값 = "+Integer.parseInt(y));
		out.println("<br>");
		out.println("z의 파라미터값 = "+Integer.parseInt(z));
		out.println("<br>");
		
//		오늘 이거 함수로 축약해서 출력해보기
		out.println("</h1>");
		out.println("<h1>");
		//out.println("<h1>"+x"+"+y+"="+(intx+inty)+"</h>");
		switch(opv) {
		case "p":
			out.println("x+y의 파라미터값 = "+(Integer.parseInt(x)+Integer.parseInt(y)));
			break;
		case "m":
			out.println("x*y의 파라미터값 = "+(Integer.parseInt(x)*Integer.parseInt(y)));
			break;
		}
		
		out.println("</h1>");
		
		out.println("</body>");
		out.println("</html>");;
		
	}

}

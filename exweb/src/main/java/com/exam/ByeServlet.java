package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이 서블릿을 요철 받았을때 실행되는 서블릿으로 등록하고, 
//bye.do 주소로 요청이 오면 실행
@ WebServlet("/bye.do")///bye.do 이런건 작성자 마음대로 정하는거임
//질문 @ WebServlet("/bye.do") 이렇게 등록해놓고, web.xml에도 똑같은 이름으로 들록하면 어떻게 되는거냐?
//두개의 주소가 매핑 되기때문에 오류가 나가 된다.
//web/xml에서 
//<!--com.exam.HelloServlet클래스를 bye라는 이름으로 등록-->
//<servlet>
//<servlet-name>bye</servlet-name>
//<servlet-class>com.exam.ByeServlet</servlet-class>
//</servlet>
//<!-- /hello.do 주소로 요청이 오면 Hello 라는 이름이ㅡ 서블릿 클래스를 실행 -->
//<servlet-mapping>
//<servlet-name>bye</servlet-name>
//<url-pattern>/bye.do</url-pattern>
//</servlet-mapping>
//해당 주소로 1개의 매핑주소가 설정되고

//다시 ByeServlet.java로 와서 @ WebServlet("/bye.do")에따라 또 매핑주소가 중복되어 설정되기 때문에 오류가 나게된다.

public class ByeServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("ByeServelt 실행됨");
		//츨력스트림을 가져오기 전에 응답개체의 문자인코딩 설정
		resp.setCharacterEncoding("UTF-8");
				
		//응답내용잉 html 문서 텍스트임을 클라이언트에게 알려줌
		resp.setContentType("text/html");
		
		//위에 두개 합쳐서 쓰는법
		//resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		//응답객체에 출력하는 코드
		//웹브라우저에서 https://localhost:8000/exweb/bye.do로 요청을 보내면 
		//브라우저 화면에서 byebye 라고 출력하도록 해보새요
		//out.println("byebye");
		
		//큰제목으로 Bye Bye
		//작은 제목으로 안녕히 출력
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1>Bye Bye</h1>\r\n"
				+ " <h2>안녕히\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		
	}

}

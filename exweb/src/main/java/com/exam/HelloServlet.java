package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹어플리케이션 서버(톰켓)을 통해서 실행되는 자바 클래스를 작성하기 위해서는
//일반적으로 httpservlet 클래스를 상속
//상속이라는건 그 클래스의 내용을 그대로 사용하겠다는 의미
//톰켓이 사용하는 클래스가 httpservlet이다.
//httpservlet에서 규정한 함수들을 이용해서 코드를 꾸민다.
//이를 servlet인터페이스를 구현한다고 한다.

//서블릿 클래스와 요청 주소를 연결하는 방법
//1.web.xml 파일에 등록
//2.@SebServlet을 클래스에 사용(톰켓버전에 따라 못쓸수도 있음)
public class HelloServlet extends HttpServlet {
	
	//serv 치고 컨트롤 스페이스 하고 첫번째꺼 누르면 나온다.
	//현재 서블릿클래스에 맞는 요청이 올때마다 한번씩 실행
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//HttpServletRequest req 요청객체
		//HttpServletResponse resp 응답객체
		//실행시키면서 요청객체와 응답객체를 인자로 전달
		//요청객체: 클라이언트(웹 브라우저)가 보낸 모든 정보를 담고있다.
		//응답객체: 클라이언트에게 (응답으로)보낼 정보들을 저장할 수 있다.
		//현제 컴퓨터의 출력객체에 출력하는 코드
		System.out.println("HelloServlet 실행됬다제~");
		
		//츨력스트림을 가져오기 전에 응답개체의 문자인코딩 설정
		resp.setCharacterEncoding("UTF-8");
		
		//응답내용잉 html 문서 텍스트임을 클라이언트에게 알려줌
		resp.setContentType("text/html");
		
		//위에 두개 합쳐서 쓰는법
				//resp.setContentType("text/html;charset=UTF-8");
		
		//응답개체에 응답내용을 쓸 수있는 출력스트림 가져오기
		PrintWriter out = resp.getWriter();
		//응답객체에 출력하는 코드
		
		//out.println("Hello Servlet on Browser");
		//이 구문을 주석처리 안하면 뒤의 html코드가 다 출력되어버리던데 왜그런걸까?
		//->브라우저가 html을 받았다고 인식을 못하고 그냥 전부 글자를 받았다고 인식해버리기때문에 뒤에 구문이 다 문자열로 나와버린다.
		//resp.setContentType("text/html"); 위에 해당 코드가 있다면 
		//out.println("Hello Servlet on Browser");코드를 출력하더라도
		//뒤의 html 코드가 정상적으로 출력되는걸 알수있다.
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");;
		//==out.println("<meta charset='UTF-8'>");; html에서 속성값은 문자열표시할시 홑따옴표도 가능하다
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello Servlet on Browser</h1>");
		out.println("<h2>안녕!</h2>");
		out.println("</body>");
		out.println("</html>");;
		//웹브라우저에서 https://localhost:8000/exweb/bye.do로 요청을 보내면 
		//브라우저 화면에서 byebye 라고 출력하도록 해보새요
	}

}

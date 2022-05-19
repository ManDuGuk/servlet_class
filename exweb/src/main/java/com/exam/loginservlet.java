//요청주소?파라미터명= 파라미터값&파라미터명= 파라미터값
//http://localhost:8000/exweb/login.do?id=아이디&pw=비밀번호
//로 요청을 보내면 
//아이디와 비밀번호가 일치하지 않으면 "로그인 실패" 출력
//아이디와 비밀번호가 일치하고 
//아이디가 user이고
//비밀번호가 "1234"이면 "사용자 화면 " 출력
//비밀번호가 올바르지 않으면 "로그인 실패"출력
//아이디가 admin이고
//비밀번호가 "qwer"이면 "관리자 화면" 출력
//비밀번호가 올바르지 않으면 "로그인 실패"출력
//다른 아이디면, "등록되지 않은 사용자" 출력
//**************************
//모든 파라미터의 값은 문자열!!!
//**************************
package com.exam;

import java.awt.Image;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Url;

@WebServlet("/login.do")
public class loginservlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// URL url =new URL("https://picsum.photos/id/1020/200/300");
		// 내가쓴 잘못된 코드
		System.out.println("login 실행됨");
		String mid = req.getParameter("id");
		String mpw = req.getParameter("pw");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		;
		// ==out.println("<meta charset='UTF-8'>");; html에서 속성값은 문자열표시할시 홑따옴표도 가능하다
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>아이디와 패스워드를 입력하세요</h1>");

		// 아이디와 비밀번호가 일치하지 않으면 "로그인 실패" 출력
		// 아이디와 비밀번호가 일치하고
		// 아이디가 user이고
		// 비밀번호가 "1234"이면 "사용자 화면 " 출력
		// 비밀번호가 올바르지 않으면 "로그인 실패"출력
		// 아이디가 admin이고
		// 비밀번호가 "qwer"이면 "관리자 화면" 출력
		// 비밀번호가 올바르지 않으면 "로그인 실패"출력
		// 다른 아이디면, "등록되지 않은 사용자" 출력
		//문자열은 객체이기 때문에 등호를 써서 비교하면 안되고 메소드를 써서 비교해야 한다.
		if (mid.equals("user")) {
			if (mpw.equals("1234")) {
				out.println("<h1>사용자 화면</h1>");
				out.println("<img src ='https://picsum.photos/id/1020/200/300'>");
			} else {
				out.println("<h1>로그인 실패</h1>");
				out.println("<img src ='https://picsum.photos/id/1025/200/300'>");
			}

		} else if (mid.equals("admin")) {
			if (mpw.equals("qwer")) {
				out.println("<h1>관리자 화면</h1>");
				out.println("<img src ='https://picsum.photos/id/1024/200/300'>");
			} else {
				out.println("<h1>로그인 실패</h1>");
				out.println("<img src ='https://picsum.photos/id/1025/200/300'>");
			}
		} else
			out.println("<h1>등록되지 않은 사용자<h1>");

//		

		// if
		// if
		// if
		// else이런식으로 만들어버리면 else문은 마지막 if문과 묵이기 때문에 첫번째 if의 값이 거짓이면
		// else의 알수 없습니다도 같이 출력되어 버린다.
		// 또한 모든 if문에 다 들어가서 조건 검사를 해야 하기 때문에 불필요한 연산도 길어진다.
		out.println("</body>");
		out.println("</html>");
		;

	}

}

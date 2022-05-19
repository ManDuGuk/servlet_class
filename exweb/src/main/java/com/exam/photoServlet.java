//http://localhost:8000/exweb/phto.do?img = 동물이름
//동물이름이 "bear"이면
//화면에 https://picsum.photos/id/1020/200/300 이미지 출력
//동물이름이 "eagle"이면
//화면에 https://picsum.photto/id/1024/200/300 이미지 출력
//동물이름이 "dog"이면
//화면에 https://picsum.photto/id/1025/200/300 이미지 출력
//그밖에 알수 없는 동물입니다. 출력

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

@WebServlet("/photo.do")
public class photoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// URL url =new URL("https://picsum.photos/id/1020/200/300");
		// 내가쓴 잘못된 코드
		System.out.println("photo 실행됨");
		String aniName = req.getParameter("img");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		;
		// ==out.println("<meta charset='UTF-8'>");; html에서 속성값은 문자열표시할시 홑따옴표도 가능하다
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>동물이름을 입력하세요</h1>");

		if (aniName.equals("bear")) {
			out.println("<img src ='https://picsum.photos/id/1020/200/300'>");
			//문자열은 객체이기 때문에 등호를 써서 비교하면 안되고 메소드를 써서 비교해야 한다.
		} else if (aniName.equals("eagle")) {
			out.println("<img src ='https://picsum.photos/id/1024/200/300'>");
		} else if (aniName.equals("dog")) {
			out.println("<img src ='https://picsum.photos/id/1025/200/300'>");
		} else
			out.println("<h1>알수없습니다.</h1>");
		
		//if
		//if
		//if
		//else이런식으로 만들어버리면 else문은 마지막 if문과 묵이기 때문에 첫번째 if의 값이 거짓이면
		//else의 알수 없습니다도 같이 출력되어 버린다.
		//또한 모든 if문에 다 들어가서 조건 검사를 해야 하기 때문에 불필요한 연산도 길어진다.
		out.println("</body>");
		out.println("</html>");
		;

	}

}

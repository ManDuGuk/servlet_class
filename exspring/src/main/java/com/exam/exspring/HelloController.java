package com.exam.exspring;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	//http://localhost:8000/exspring/hello.do?x=3&y=4 로 요청을 보내면
	//화면에 
	//계산결과 :3+4=7 
	//현재서버시간 :2022년 6월 9일...
	//라고 출력되도록 구현
	//파라미터 값은 MyValue 객체로 받고,
	//계산 결과는 MyValue 객체의 sum 변수에 저장
	//출력은 hello.jsp 파일에서 화면 출력
	
	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public String hello(Locale locale, MyValue mv , Map<String,Object> map) {
		
		//mv.getX();
		//mv.getY();
		mv.setSum(mv.getX()+mv.getY());
		//model.addAttribute("mv", mv);
		
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분");
//		String fmtDate = dateFormat.format(date);
//		model.addAttribute("now",fmtDate);
		map.put("now", new Date());
		
		return "hw/hello";
	}
}

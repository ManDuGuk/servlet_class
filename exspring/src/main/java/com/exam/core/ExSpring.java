package com.exam.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.*;

public class ExSpring {

	public static void main(String[] args) {
		
//		MyApp ma = new MyApp();
//		//ma.setMyService(new MyServiceEn());
//		ma.setMyService(new MyServiceKo());
//		ma.say();
		
		//스프링 컨테이너==어플리케이션 컨텍스트:객체를 생성하여 저장
//		com/exam/core/context.xml 설정파일의 내용대로 스프링 컨테이너를 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("com/exam/core/context.xml");
		
		//MyConfig.class 설정파일의 내용대로 스프링 컨테이너를 생성
		//ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		//스프링에 ma 라는 이름으로 등록된 객체를 가져오기
		MyApp app=(MyApp) context.getBean("ma");
		app.say();
		
		//스프링에 등록되어있는 객체들의 목록
//		for(String bn :context.getBeanDefinitionNames()) {
//			System.out.println(bn+":"+context.getBean(bn).getClass().getName());
//		}
	}
}

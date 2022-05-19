package com.exam.comm;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//(이벤트)리스너 
//이벤트가 발생하나 안하나 항상 귀를 기울이고 있다.
//웹 어플리케이션에 특정 사건이 발생했을 때 자동으로 실행되는 클래스(의 리스너 메소드들)
//ServletContextListener,ServletContextAttributeListener
//SessionListener,SessionAttributeListener
//RequestListener,RequestAttributeListener
//기타등등

//ServletContextListener
//==ServletContextListener 객체가  생성과 소멸시에 자동 실행
//==웹 어플리케이션이 처음 실행될 때와 종료될떄 자동 실행

//리스너를 등록하는 방법
//1.web.xml에 <listener> 를 사용하여 등록
//2.리스너 클래스에 @WebListener 어노테이션 적용
public class MyListener implements ServletContextListener{


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//웹 어플리케이션이 처음 시작될때 실행
		System.out.println("MyListener:contextInitialized");
		
		ServletContext sc = sce.getServletContext();
		String jd = sc.getInitParameter("jdbcDriver");
		//MemberDao,StudentDao에 공통적으로 적용되게 된다
		//중괄호는 메소드 밖에 놓을때 사용한건데 놔두어도 되고 지원도 된다.
		{//초기화 블럭
			
			
			// 여기도 필터에서 처리하면좋다. 리스너로 처리하도록 하겠다.
			///////////////////////jdbc///////////////////////////
			try {
			
			Class.forName(jd);
			
			} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			}
			
			
			///////////////////////jdbc/////////////////////////////
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//웹 어플리케이션이 종료될때 실행
		System.out.println("MyListener:contextDestroyed");
		
	}

}

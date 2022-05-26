package com.exam.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	private static SqlSessionFactory sqlSessionFactory=null;
	
	//생성자 대신에 초기화 블럭을 써볼것이다.
	static {
		
		try {
			//마이바티스 설정 파일 위치
			String resource = "mybatis/mybatis-config.xml"; 
			//마이바티스 설정파일을 읽을수 있는 입력 스트림
			InputStream inputStream = Resources.getResourceAsStream(resource); 
			//마이바티스 설정 파일의 내용대로 마이바티스 본체(sqlSessionFactory)를 생성
			//sqlSessionFactory는 하나의 어플리케이션에서 하나만 만들어 쓰는 편이 좋다. 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}	
	
}

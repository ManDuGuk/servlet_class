package com.exam.student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.exam.comm.MyBatisUtil;
import com.exam.member.MemberDaoBatis;
import com.exam.member.MemberVo;

public class StudentDaoBatis implements StudentDao{
	
	
	//싱글톤(Singleton)패턴
		/////////////////////////////////////////////////////////////////////////////////////////
		
		//클래스의 인스턴스를 1개만 생성하여 애플리케이션 전체에서 공유하여 사용하고 싶을 때 
		//생성자를 하나 만들자
		//클래스 외부에서 생성자 호출을 금지하기 위해 private로 묶는다.
		private StudentDaoBatis() {}
		
		//클래스 내부에서 인스턴스 생성 및 보관
		//자기 자신의 객체를 내부에 생성했다.
		//MemberDaoBatis는 해당 코드를 포함해서 다 정의 되어진것이고
		//아래 코드는 해당 getInstance코드가 호출되서 실행되어질떄 그때 사용이 되면서 실행되는것이다.
		//이는 자바를 좀더 공부하자.헷갈린다.
		//이미 아래 MemberDaoBatis는 다 정의 되어진 것이고 아래코드는 스택틱이 실행될때 생성되서 실행되는 코드이다.
		private static StudentDaoBatis studentDaoBatis=new StudentDaoBatis();

		
		//어디서든 접근 가능하도록 설정
		//클래스 외부에서 필요한 경우,보관한 인스턴스를 제공하는 메소드
		public static StudentDaoBatis getInstance() {
			return studentDaoBatis;
		}
	    /////////////////////////////////////////////////////////////////////////////////////////
		
		
		//sqlSessionFactory는 하나의 어플리케이션에서 하나만 만들어 쓰는 편이 좋다. 
		//MybatisUtill에서 가져온 sqlSessionFactory를 공유해서 쓰겠다.
		private SqlSessionFactory sqlSessionFactory=MyBatisUtil.getSqlSessionFactory();

		//MybatisUtill에서 가져올것이다.
		
//		public MemberDaoBatis() {
//			
//			try {
//				//마이바티스 설정 파일 위치
//				String resource = "mybatis/mybatis-config.xml"; 
//				//마이바티스 설정파일을 읽을수 있는 입력 스트림
//				InputStream inputStream = Resources.getResourceAsStream(resource); 
//				//마이바티스 설정 파일의 내용대로 마이바티스 본체(sqlSessionFactory)를 생성
//				//sqlSessionFactory는 하나의 어플리케이션에서 하나만 만들어 쓰는 편이 좋다. 
//				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
//			} catch (IOException e) {
//				e.printStackTrace();
//			} 
//			
//		}


	@Override
	public List<StudentVo> selectMemberList() {
		//마이바티스를 통한 데이터베이스와의 세션(연결)을 가져와서
		List<StudentVo> list=null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			//해당 세션을 통해 마이바티스에 등록된 sql문을 실행
			//실행할 sql문의 종류에 따라서 메서드를 선택
			//실행할 sql문의 종류에 따라서 메서드를 선택
			//"namespace.id"로 실행할 sql문을 지정
			 
			list = session.selectList("com.exam.student.StudentDao.selectMemberList");
			}
		return list;
	}
	
	@Override
	public StudentVo selectMember(String memId) {
		StudentVo vo=null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			
			vo = session.selectOne("com.exam.student.StudentDao.selectMember",memId);
			}
		return vo;
	}

	@Override
	public int insertMember(StudentVo vo) {
		int num=0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			 
			//sql문 실행에 필요한
			num = session.insert("com.exam.student.StudentDao.insertMember",vo);
			//insert,update,delete 후에는 커밋필요
			session.commit();
			}
		
		return num;
	}

	@Override
	public int delMember(String memId) {
		int num=0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			 
			//sql문 실행에 필요한 데이터는 두번째 인자로 전달
			num = session.delete("com.exam.student.StudentDao.delMember",memId);
			//insert,update,delete 후에는 커밋필요
			session.commit();
			}
		
		return num;
	}

	

	@Override
	public int updatetMember(StudentVo vo) {
		int num=0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			 
			num = session.update("com.exam.student.StudentDao.updatetMember",vo);
			
			session.commit();
			}
		
		return num;
	}

	@Override
	public StudentVo selectLoginMember(StudentVo vo) {
		StudentVo memVo=null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			
			memVo = session.selectOne("com.exam.student.StudentDao.selectLoginMember",vo);
			}
		return memVo;
	}

	

}

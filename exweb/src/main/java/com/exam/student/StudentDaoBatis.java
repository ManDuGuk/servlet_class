package com.exam.student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StudentDaoBatis implements StudentDao{
	SqlSessionFactory sqlSessionFactory=null;

	public StudentDaoBatis() {
		
		try {
			//마이바티스 설정 파일 위치
			String resource = "mybatis2/mybatis-config.xml"; 
			//마이바티스 설정파일을 읽을수 있는 입력 스트림
			InputStream inputStream = Resources.getResourceAsStream(resource); 
			//마이바티스 설정 파일의 내용대로 마이바티스 본체(sqlSessionFactory)를 생성
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

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

	

}

package com.exam.exspring.member;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.exam.core.MyBatisUtil;

//@Repository
public class MemberDaoBatis implements MemberDao{
	
	//servlet-context.xml에 정의되있는.. 
	@Autowired
	//private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;

	@Override
	public List<MemberVo> selectMemberList() {
		
		
		return session.selectList("com.exam.exspring.member.MemberDao.selectMemberList");
	}
	
	@Override
	public MemberVo selectMember(String memId) {
		
		return session.selectOne("com.exam.exspring.member.MemberDao.selectMember",memId);
	}

	@Override
	public int insertMember(MemberVo vo) {
		
		
		return session.insert("com.exam.exspring.member.MemberDao.insertMember",vo);
	}

	@Override
	public int delMember(String memId) {
	
		
		return session.delete("com.exam.exspring.member.MemberDao.delMember",memId);
	}

	

	@Override
	public int updatetMember(MemberVo vo) {
		
		
		return session.update("com.exam.exspring.member.MemberDao.updatetMember",vo);
	}

	@Override
	public MemberVo selectLoginMember(MemberVo vo) {
	
		return session.selectOne("com.exam.exspring.member.MemberDao.selectLoginMember",vo);
	}

	

}

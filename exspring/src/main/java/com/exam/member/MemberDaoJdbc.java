package com.exam.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//public class MemberDaoJdbc implements MemberDao {	
//
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String user = "web";
//	String password = "web01";
//	
//	@Override
//	//List로 만든것은 인터페이스 객체를 사용한것이고//arrayList는 list를 확장해서 만든 객체이기에
//	//List인 인터페이스를 씀으로써 여러 리스트의 종류를 사용할때 충돌없이 쓰기위해 그리만든것이다.
//	//arraylist에서 좀더 넓은 개념으로 옮겨갔다고 생각하면 편하다.
//	public List<MemberVo> selectMemberList() {
//	
//		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
//		String selectSql = "SELECT mem_id,mem_pass,mem_name,mem_point FROM MEMBER";
//		try (
//				Connection conn = DriverManager.getConnection(url, user, password);
//				PreparedStatement pstmt = conn.prepareStatement(selectSql);
//				ResultSet rs = pstmt.executeQuery();) {
//
//			while (rs.next()) {
//
//				MemberVo vo = new MemberVo();
//				vo.setMemId(rs.getString("mem_id"));
//				vo.setMemPass(rs.getString("mem_pass"));
//				vo.setMemName(rs.getString("mem_name")); 
//				vo.setMemPoint(rs.getInt("mem_point")); 
//				list.add(vo);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
//	@Override
//	public int insertMember(MemberVo vo) {
//		//데이터 베이스 member 테이블에 회원정보를 insert하도록 여기다가 코드
//		int num=0;
//		String insertSql = "INSERT into MEMBER" + "(mem_id,mem_pass,mem_name,mem_point)"
//				+ "VALUES(?,?,?,?)";
//		
//		try (
//				Connection conn = DriverManager.getConnection(url, user, password);
//				PreparedStatement pstmt = conn.prepareStatement(insertSql);
//
//		)
//
//		{
//			//?에 주입할 값의 타입에 따라서 setxxx()메서드 사용
//			pstmt.setString(1, vo.getMemId()); //pstmt에 담긴 sql문의 첫번째 ?에 id값을 주입
//			pstmt.setString(2, vo.getMemPass()); 
//			pstmt.setString(3, vo.getMemName()); 
//			pstmt.setInt(4, vo.getMemPoint()); 
//			
//			num = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return num;
//	}
//	@Override
//	public int delMember(String memId) {
//		//입력한 아이디의 회원을 member 테이블에서 삭제
//		int num=0;
//		String delSql = "DELETE from MEMBER where mem_id =?";
//		
//		try (
//				Connection conn = DriverManager.getConnection(url, user, password);
//				PreparedStatement pstmt = conn.prepareStatement(delSql);
//			
//
//		)
//
//		{
//			pstmt.setString(1, memId);			
//			num=pstmt.executeUpdate();
//			
//			
//			
//		} 
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return num;
//	}
//}

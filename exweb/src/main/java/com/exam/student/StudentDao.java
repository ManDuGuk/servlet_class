package com.exam.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.member.MemberVo;

public interface StudentDao {
	
	List<StudentVo> selectMemberList();

	int insertMember(StudentVo vo);

	int delMember(String memId);

	StudentVo selectMember(String memId);

	int updatetMember(StudentVo vo);
	
//	//Data
//	//Access
//	//Object
//	//
//	//java Object <-> DB Table
//
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String user = "web";
//	String password = "web01";
//	
////	{//초기화 블럭
////		///////////////////////jdbc///////////////////////////
////		try {
////		
////		Class.forName("oracle.jdbc.OracleDriver");
////		
////		} catch (ClassNotFoundException e) {
////		
////		e.printStackTrace();
////		}
////		
////		
////		///////////////////////jdbc/////////////////////////////
////	}
//	
//	public ArrayList<StudentVo> selectList() {
//		//데이터베이스 member 테이블의 정보를 select하여 출력
//		
//		//여기다가코드//////////////////////////jdbc//////////////////////////////////
//		ArrayList<StudentVo> list = new ArrayList<StudentVo>();
//		String selectSql = "SELECT stu_no,stu_name,stu_score FROM student";
//		try (
//				Connection conn = DriverManager.getConnection(url, user, password);
//				PreparedStatement pstmt = conn.prepareStatement(selectSql);
//				ResultSet rs = pstmt.executeQuery();) {
//
////			rs.next();
////
////			String memId = rs.getString("stu_no");
////			String memPass = rs.getString("stu_name");
////			int memPoint = rs.getInt("stu_score");
////
////			System.out.println(memId + "," + memPass + "," + memPoint);
//
//			while (rs.next()) {
//
//				StudentVo vo = new StudentVo();
//				vo.setMemId(rs.getString("stu_no"));
//				vo.setMemName(rs.getString("stu_name"));
//				vo.setMemPoint(rs.getInt("stu_score")); 
//				list.add(vo);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		//여기다가코드//////////////////////////jdbc//////////////////////////////////
//		return list;
//	}
//	public int insert(StudentVo vo) {
//		//데이터 베이스 member 테이블에 회원정보를 insert하도록 여기다가 코드
//		int num=0;
//		String insertSql = "INSERT INTO STUDENT" + "(STU_NO,STU_NAME,STU_SCORE)"
//				+ "VALUES(?,?,?)";
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
//			pstmt.setString(2, vo.getMemName()); 
//			pstmt.setInt(3, vo.getMemPoint()); 
//			
//			num = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return num;
//	}
//	public int delete(String memId) {
//		//입력한 아이디의 회원을 member 테이블에서 삭제
//		int num=0;
//		String delSql = "DELETE FROM STUDENT WHERE STU_NO =?";
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
////	UPDATE 테이블이름
////
////	SET 필드이름1=데이터값1, 필드이름2=데이터값2, ...
////
////	WHERE 필드이름=데이터값
////	set stu_no='1111',STU_NAME='update',STU_SCORE='100'
////	where STU_NAME='시공조아';
//	public int update(String memName,StudentVo vo) {
//		//데이터 베이스 member 테이블에 회원정보를 insert하도록 여기다가 코드
//		int num=0;
//		String updateSql = "UPDATE STUDENT" + " SET STU_NO=?,STU_NAME=?,STU_SCORE=?"
//		+" WHERE STU_NAME=?";
//		
//		try (
//				Connection conn = DriverManager.getConnection(url, user, password);
//				PreparedStatement pstmt = conn.prepareStatement(updateSql);
//
//		)
//
//		{
//			//?에 주입할 값의 타입에 따라서 setxxx()메서드 사용
//			pstmt.setString(1, vo.getMemId()); //pstmt에 담긴 sql문의 첫번째 ?에 id값을 주입
//			pstmt.setString(2, vo.getMemName()); 
//			pstmt.setInt(3, vo.getMemPoint()); 
//			pstmt.setString(4,memName); 
//			
//			num = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return num;
//	}
}

package com.exjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	
	//Data
	//Access
	//Object
	//
	//java Object <-> DB Table

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "web";
	String password = "web01";
	
	{//초기화 블럭
		///////////////////////jdbc///////////////////////////
		try {
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
		}
		
		
		///////////////////////jdbc/////////////////////////////
	}
	
	public ArrayList<MemberVo> selectList() {
		//데이터베이스 member 테이블의 정보를 select하여 출력
		
		//여기다가코드//////////////////////////jdbc//////////////////////////////////
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String selectSql = "SELECT mem_id,mem_pass,mem_name,mem_point FROM MEMBER";
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(selectSql);
				ResultSet rs = pstmt.executeQuery();) {

			rs.next();

			String memId = rs.getString("mem_id");
			String memPass = rs.getString("mem_pass");
			String memName = rs.getString("mem_name");
			int memPoint = rs.getInt("mem_point");

			System.out.println(memId + "," + memPass + "," + memName + "," + memPoint);

			while (rs.next()) {

				MemberVo vo = new MemberVo();
				vo.setMemId(rs.getString("mem_id"));
				vo.setMemPass(rs.getString("mem_pass"));
				vo.setMemName(rs.getString("mem_name")); 
				vo.setMemPoint(rs.getInt("mem_point")); 
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//여기다가코드//////////////////////////jdbc//////////////////////////////////
		return list;
	}
	public int insert(MemberVo vo) {
		//데이터 베이스 member 테이블에 회원정보를 insert하도록 여기다가 코드
		int num=0;
		String insertSql = "INSERT into MEMBER" + "(mem_id,mem_pass,mem_name,mem_point)"
				+ "VALUES(?,?,?,?)";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(insertSql);

		)

		{
			//?에 주입할 값의 타입에 따라서 setxxx()메서드 사용
			pstmt.setString(1, vo.getMemId()); //pstmt에 담긴 sql문의 첫번째 ?에 id값을 주입
			pstmt.setString(2, vo.getMemPass()); 
			pstmt.setString(3, vo.getMemName()); 
			pstmt.setInt(4, vo.getMemPoint()); 
			
			num = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	public int delete(String memId) {
		//입력한 아이디의 회원을 member 테이블에서 삭제
		int num=0;
		String delSql = "DELETE from MEMBER where mem_id =?";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(delSql);
			

		)

		{
			pstmt.setString(1, memId);			
			num=pstmt.executeUpdate();
			
			
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
}

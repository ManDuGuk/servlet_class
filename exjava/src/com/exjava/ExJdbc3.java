package com.exjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExJdbc3 {

	public static void main(String[] args) {

		try {

			Class.forName("oracle.jdbc.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		String user = "web";
		String password = "web01";

		
		//"삭제할 회원 아이디를 입력하세요"라고 출력하고,
		//키보드로 입력한 아이디의 회원을 삭제하도록 구현
		
		System.out.println("삭제할 회원 아이디를 입력하세요");
		Scanner sc =new Scanner(System.in);
		System.out.println("아이디: ");
		String id = sc.nextLine();
		
		String deleteId = "DELETE from MEMBER where mem_id =?";
	
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(deleteId);
			

		)

		{
			pstmt.setString(1, id);
			int num=pstmt.executeUpdate();
			System.out.println(num+"개 삭제됨");
			
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		//-------------------------------------------------------------------------------
		
		
		
		sc.close();
	}

}

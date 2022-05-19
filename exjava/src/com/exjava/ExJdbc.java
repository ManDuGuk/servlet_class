package com.exjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//jdbc
//java database connectivity
//java 프로그래밍언어를 사용하여 데이터베이스에 연결학소
//sql 명령문을 실행하기 위해여 사용하는 규칙
public class ExJdbc {

	public static void main(String[] args) {
		//오라클 jdbc 드라이버 클래스를 메모리에 로드
		//데이터베이스 연결 전에 최초 1회만 실행 필요
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			//여기 빨간줄에 ctrl+1해서  try catch 만들어줌, 위아래의 try catch가 만들어진 코드
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";//데이터베이스 서버 주소
		//구글에 oracle jdbc connection검색
		String user="web"; //데이터베이스 사용자 아이디
		String password="web01"; //데이터 베이스 사용자 비밀번호
		
		//모든변수를 바꿀때 바꿀변수클릭 alt+shift+R
		String selectSql = "SELECT mem_id,mem_pass,mem_name,mem_point FROM MEMBER";//sql문 불러올때 뒤에 세미콜론은 지워라
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				//해당 데이터 베이스 연결을 통해서 실행할 sql문 준비
				PreparedStatement pstmt=conn.prepareStatement(selectSql); 
				//명령문객체에 담겨있는 sql문을 실행
				//실행 후 결과 데이터를 받는 sql(select)문은 executeQuery() 사용
				//실행 후 결과 데이터가 없는 sql(insert,update,delete)문은 executeUpdate() 사용
				ResultSet rs = pstmt.executeQuery();
				)
				{
					//getconnction에 컨트롤1 눌러서 assing뭐시기 해준다.
			        //Connection conn = DriverManager.getConnection(url, user, password);
			        ////해당 데이터 베이스 연결을 통해서 실행할 sql문 준비
			        //			String sql = "SELECT mem_id,mem_pass,mem_name,mem_point FROM MEMBER";
			        //			PreparedStatement pstmt=conn.prepareStatement(sql); //sql문 불러올때 뒤에 세미콜론은 지워라
			        //			//명령문객체에 담겨있는 sql문을 실행
			        //			//실행 후 결과 데이터를 받는 sql(select)문은 executeQuery() 사용
			        //			//실행 후 결과 데이터가 없는 sql(insert,update,delete)문은 executeUpdate() 사용
			        //			ResultSet rs = pstmt.executeQuery();
					//select 실행 결과 데이터가 저장되어 있는ResultSet은
					//처음에는 첫 레코드(행) 이전을 가리키고 있고,
					//다음 레코드를 가리키도록 한 다음, 해당 레코드의 컬럼 값을 조회
					rs.next();//다음레코드를 가리키도록 //다음 레코드가 있으면 true를 반환함
					//컬럼 값의 타입에 따라서 rs.getxxxx(컬럼명)을 사용하여
					//현재 ResultSet이 가리키는 레코드의 컬럼값을 읽기
					String memId = rs.getString("mem_id");//현재 가리키는 레코드의 mem_id컬럼 값 읽기
					String memPass = rs.getString("mem_pass");
					String memName = rs.getString("mem_name");
					int memPoint = rs.getInt("mem_point");
					
					System.out.println(memId+","+memPass+","+memName+","+memPoint);
					
					//rs.next();
					//다음 레코드가 있으면 true를 반환,없으면 false를 반환
					while (rs.next()) { // 다음 레코드가 있는 동안 반복
						
						memId = rs.getString("mem_id");
						memPass = rs.getString("mem_pass");
						memName = rs.getString("mem_name");
						memPoint = rs.getInt("mem_point");
						System.out.println(memId + "," + memPass + "," + memName + "," + memPoint);
					}
					
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
			
			
//			finally { //try{} 내부에서 오류 발생 여부와 상관없이 무조건 실행
//			// try{}를 벗어났기 때문에 지역변수를 쓰려고 하니 오류가난다.
//			rs.close(); //사용이 끝나면 ResultSet의 자원을 반납(해제)
//			pstmt.close();//사용이 끝나면PreparedStatement의 자원을 반납
//			conn.close(); //데이터베이스 연결 종료
//		}
		//DriverManager.getConnection(url, user, password); //데이터 베이스 접속(연결)
		//마찬가지로 빨간줄에 컨트롤 1해서 지역변수를 만들어준다.
		//그리고 예외처리
//-------------------------------------------------------------------------------------------------------------------------		
		String insertSql = "INSERT into MEMBER"
				+ "(mem_id,mem_pass,mem_name,mem_point)"
				+ "VALUES('a003','9012','도우너',80)";
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				//해당 데이터 베이스 연결을 통해서 실행할 sql문 준비
				PreparedStatement pstmt=conn.prepareStatement(insertSql); //sql문 불러올때 뒤에 세미콜론은 지워라
				
			)
				
		{
					//명령문객체에 담겨있는 sql문을 실행
					//실행 후 결과 데이터를 받는 sql(select)문은 executeQuery() 사용
					//실행 후 결과 데이터가 없는 sql(insert,update,delete)문은 executeUpdate() 사용
					int num = pstmt.executeUpdate(); //sql문 실행결과 변경된 레코드 수를 반환 실패하면 0을 반환
					
				
					System.out.println(num+"개의 레코드 추가");
					
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}

}

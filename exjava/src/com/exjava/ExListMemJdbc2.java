package com.exjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExListMemJdbc2 {
	
	public static void main(String[] args) {
		
		MemberDao memberDao = new MemberDao();
		Scanner sc = new Scanner(System.in);
	
		boolean flag= true;
		while (flag) {
			System.out.println("1.목록 2.추가 3.삭제 4.종료");
			String menu = sc.nextLine();
			switch (menu) {
			case "1": {
				
				ArrayList<MemberVo> list = memberDao.selectList();

				

				//만약에 case2를 실행시키지 않고 1만 실행해본다면 오류가 날것 같지만 나지 않는다.
				//liset.size=0이 되어버리기때문에 for문 자체를 돌지 않게된다. 그래서 break;
				for(int i=0;i<list.size();i++) {
					MemberVo vo= list.get(i);//MemberVo 는 변수를 하나더 선언한거다. 얼핏보면 그렴 변수명이 중복되는것이 아닌가 할수 있지만
					//for 문 안에서 돌고있는 변수이니 for문을 나간 순간 사라지는 변수이다.
					//만약 해당 vo를 for문 밖에 선언한다면 오류가 나는걸 볼수 있을 것이다.
					System.out.println(vo.getMemId()+" : "+vo.getMemPass()+" : "+vo.getMemName()+" : "+vo.getMemPoint());
				}
//				for(String n:list)
//					System.out.println(n);
				break;
			}
			case "2":{
				
				//데이터 베이스 member 테이블에 회원정보를 insert하도록
				
				MemberVo vo = new MemberVo();
				//목록에 데이터 추가
				//추가할 회원이름을 입력받아서 list에 저장(추가)
				System.out.println("아이디을 입력해주세요");
				vo.setMemId(sc.nextLine());
				System.out.println("비밀번호을 입력해주세요");
				vo.setMemPass(sc.nextLine());
				System.out.println("이름을 입력해주세요");
				vo.setMemName(sc.nextLine());
				System.out.println("포인트을 입력해주세요");
				vo.setMemPoint(Integer.parseInt(sc.nextLine()));
				
				int num =memberDao.insert(vo);
				System.out.println(num + "개의 레코드 추가");
				break;
			}
			case "3":{
				//목록의 데이터 삭제
				//삭제할 회원이름을 입력 받아서 list에서 삭제
				System.out.println("삭제할 아이디을 입력해주세요");
				String memId=sc.nextLine();
				
				
				int num= memberDao.delete(memId);
				System.out.println(num+"개 삭제됨");

				break;
			}
			case "4":
				flag=false;
				break;

			default:

				System.out.println("알수없는 메뉴");
				break;
			}
		}
		
		
		
	}
	
	
}

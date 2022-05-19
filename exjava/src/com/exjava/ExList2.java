package com.exjava;

import java.util.ArrayList;
import java.util.Scanner;

public class ExList2 {

	public static void main(String[] args) {
		//ArrayList: 다수의 값을 저장할수 있는 배열과 유사한 목록
		//<E>안에는 타입을 써준다.
		ArrayList<String> list = new ArrayList<String>();//문자열 여러개를 저장할수 있는 목록 생성
		
		Scanner sc = new Scanner(System.in);
	
		boolean flag= true;
		while (flag) {
			System.out.println("1.목록 2.추가 3.삭제 4.종료");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				//목록 출력
				//list 에 저장되어 있는 회원 이름들을 모두 출력
				System.out.print("저장된 리스트수");
				System.out.println(list.size());
//				for(int i=0;i<list.size();i++)
//					System.out.println(list.get(i));
				for(String n:list)
					System.out.println(n);
				break;

			case "2":
				//목록에 데이터 추가
				//추가할 회원이름을 입력받아서 list에 저장(추가)
				System.out.println("이름을 입력해주세요");
				String name=sc.nextLine();
				list.add(name);
				break;

			case "3":
				//목록의 데이터 삭제
				//삭제할 회원이름을 입력 받아서 list에서 삭제
				System.out.println("삭제할 이름을 입력해주세요");
				String delName=sc.nextLine();
//				list.remove(delName); //이렇게도 할수있지만 우리는 앞전에 인덱스 값을 입력받아서 해봤으니까.아래처럼도 해봤다.
				for (int i=0;i<list.size();i++) {
					if(delName.equals(list.get(i)) ){
							list.remove(i);
							break;
					}
				}
				break;

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

package com.exjava;

import java.util.ArrayList;

public class ExList {

	public static void main(String[] args) {
		//ArrayList: 다수의 값을 저장할수 있는 배열과 유사한 목록
		//<E>안에는 타입을 써준다.
		ArrayList<String> list = new ArrayList<String>();//문자열 여러개를 저장할수 있는 목록 생성
		
		//방금위에서 만든 어레이 리스트.add("고길동"); 쓸려면 변수로 만들어야 하니까 new로 선언한 것을 변수에 자장
		list.add("고길동");//목록의 마지막에 "고길동"을 저장(추가)
		list.add("둘리");
		list.add("마이클");
		
		System.out.println(list.size());//현재 list에 저장된 데이터수 //list는 배열이 아니라 list이므로 크기를 알고 싶을때 length가 아니라 size를 써준다.
		
		System.out.println(list.get(0));//list의 0번칸에 저장된 데이터 읽기
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		list.remove(1);//list의 1번칸에 저장된 데이터 삭제(칸이라고 했지만 그냥 값 자체가 날라가고 get은 몇번째 값을 가져와라 이런 개념으로 이해하면 된다.)
		//확인작업
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	
	}
}

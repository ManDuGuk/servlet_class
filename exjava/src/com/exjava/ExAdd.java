package com.exjava;

import java.util.Scanner;

public class ExAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//x 값을 입력하세요 라고 출력
		System.out.println("x값을 입력하세요: ");
		//키보드로 숫자를 입력받아서 변수 x에 저장하기
		Scanner input = new Scanner(System.in);
		int A = input.nextInt(); 
		System.out.println(A);
		//y값을 입력하세요 라고 출력하고 변수 y에 저장
		System.out.println("y값을 입력하세요: ");
		int B = input.nextInt();
		System.out.println(B);
		// x +y = ...이락 입력 받은 두수의 값을 출력
		System.out.println(A+"+"+B+"="+(A+B));
		
		//함수를 nextline으로 받으면 숫자를 받는게 아니라 문자열로 넣기 때문에 
		//출력시 5 ,10이라고 했다면 510 이런식으로 나온다.
		
		Integer.parseInt("123");
		//문자열을 정수형으로 바꿔주는 함수
		
		//강사님 풀이는
		
//		sting x = sc.nextline();
//		처럼 문자열로 받은 변수를 
//		int nx = integer.paraseInt(x);
//		이런식으로 형변환을 해서 풀이했다.
	}

}

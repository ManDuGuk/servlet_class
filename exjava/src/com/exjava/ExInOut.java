package com.exjava;

import java.util.Scanner;

public class ExInOut {

	public static void main(String[] args) {
		
		/*
		// "좋아하는 음식을 입력하세요" 라고 출력
		// 입력한 음식을 변수에 저장
		// "좋아하는 음시은 ... 이빈다 . 라고 출력

		
		System.out.println("좋아하는 음식을 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		System.out.println("좋아하는 음식은: "+s+"입니다");
		*/
		//누구세요? 라고 출력
		//키보드로 이름을입력
		
		//....님 환영합니다. 락 출력
	
		System.out.println("누구인가?");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		System.out.println(s+"전하 환영하옵니다.");
	
	}

}

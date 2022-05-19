package com.exjava;

import java.util.Scanner;
//자동완성을 이용하면 알아서 생성된다.

public class ExInput {

	public static void main(String[] args) {
		//현재 시스템(컴퓨터)의 입력(키보드)로 부터 입력을 받을 수 있는 스캐너 생성
	Scanner	sc = new Scanner(System.in);
	//Scanner 이게 int이런거 
	
	
	//한줄을 입력받는 명령어,스캐너로부터 한줄의 문자열을 입력받기
	//엔터를 쳐야지 한줄의 입력이 끝난다.
	
	String s = sc.nextLine();
	//입력받은 값을 변수에 저장한다.
	System.out.println(s);
	}

}

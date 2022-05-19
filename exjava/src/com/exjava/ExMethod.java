package com.exjava;

public class ExMethod {
	
	//메소드가 4개존재한다

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "보노보";
		String s2 ="너부리";
		
//		*********************
//		* 보노보노 님 환영합니다 *        
//		*********************
//		* 너부리 님 환영합니다  *        
//		*********************

		System.out.println("*****************\n*"+s1+"님 환영 합니다"+"*\n*****************\n");
		System.out.println("*****************\n*"+s2+"님 환영 합니다"+"*\n*****************\n");
		
		printWelcome(s1);
		printWelcome(s2);
		
		int result =add(3,4);
		System.out.println(result);
		
		//
		//printAdd(3,4);
		// 3+4 = 7이라고 출력되도록 함수 printAdd 를 정의해보세요
		printAdd(3,4);
		
	}
	
	//************************************
	//main 함수 안에다가 정의해버리지 않도록 주의!!!!
	//************************************
		//반환값 함수이름(받을값) {함수내용}
		
		public static void printWelcome(String s)
		{
			System.out.println("*****************\n*"+s+"님 환영 합니다"+"*\n*****************\n");
		}
	
		//두 정수를 더해주는 함수 정의
		public static int add(int x,int y){
			int sum = x +y;
			return sum;
		}
		
		// 3+4 = 7이라고 출력되도록 함수 printAdd 를 정의해보세요
		public static void printAdd(int x,int y){
			int sum = x +y;
			System.out.println(x+"+"+y+"="+sum);
			
		}

}

package com.exjava;
//자바는 클래스 단위로 프로그램을 작성하고 실행한다.
public class ExOutput {
	//main 까지 치고 ctrl +space 치면 자동완성기능이 켜진다.
	//처음으로 나온거를 선택하면 아래와같이 자동으로 만들어진다.
	//클래스를 실행하면,클래스의 main 메서드를 실행
	public static void main(String[] args) {
		//마찬가지로 syso 하고 자동완성
		//문자열은 언제나 쌍따옴표
		//위에서 부터 순차적으로 명령을 실행하게된다.
		System.out.println("Hello JAVA");
		System.out.println(123);
		
		System.out.println("2 * 2 = 4");
		System.out.println("2 * 3 = 6");
		System.out.println("2 * 4 = 8");
		//이런식으로 1000개이상있다고 하면 나중에 수정하기 힘들다.
		
		//반복되는 부분을 변수를 써서 만들어보자
		
		int a = 10;
		System.out.println(a+ " * 2 = 4");
		//자바의 println함수는 두개이상의 값을 받지 않기때문에 
		//하나의 값으로 만들어줘야할 필요가 있고 이를위해 +를 쓴다.
		//문자열 +값 = > 두값을 이어 붙인 문자열
		
		System.out.println(a+ " * 2 = "+a*2);
		//자바언어에서도 연산자 우선순위가 잇기 때문에 
		System.out.println(a+ " * 2 = "+a+2);
		//이렇게 썼다면 우선순위에 따라 앞에서부터 연산이 되기 때문에 
		//뭔하는 값이 나오지 않게된다. 이를 방지하기 위해 괄호로 감싸자
		System.out.println(a+ " * 2 = "+(a+2));
	
		//나중에는 값을 바꿀려고 코드를 자주 수정하는 일은 지양해야하기때문에
		//
	}
}

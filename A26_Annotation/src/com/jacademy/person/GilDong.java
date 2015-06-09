package com.jacademy.person;


public class GilDong extends HongFamily{
	
	@Person
	private String name;
	
	@Person
	private int age = 18;
	
	private double PI = 3.1415926536;

	public GilDong() {
		// Default Constructor
	}
	
	public GilDong(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//사용될 경우 컴파일러가 경고를 발생
	@Deprecated
	public void sleep(){
		System.out.println(name + "이(가) 잠잔다.");
	}

	//부모클래스의 메소드를 바뀌게 되면 자식클래스의 메소드는 더 이상
	//오버라이드 메소드가 아니게 되므로 에러가 발생한다.
	//즉, 부모클래스의 메소드를 어느 자식클래스들! 에서 재정의 하고 있는지
	//바로 알 수 있으므로 관리(부모 클래스에 메소드를 변경해도 상관이 없는지 여부)에 도움이 된다.
	@Override
	public void doSomethingAfterMeal() {
		System.out.println("양치질을 한다.");
	}
}

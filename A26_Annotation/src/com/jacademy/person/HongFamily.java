package com.jacademy.person;

@MyAnnotation(
		age = 44, 
		name = "상직", 
		newNames = { "홍", "대감" }
)
public class HongFamily {

	@MyAnnotation(
			age = 33, 
			name = "이름", 
			newNames = { "홍", "누구" },
			value = "456"
	)
	public void doSomethingAfterMeal(){
		System.out.println("꺼어억~ 트림을 한다.");
	}
}

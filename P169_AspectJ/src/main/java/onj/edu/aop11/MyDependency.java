package onj.edu.aop11;

import org.springframework.stereotype.Component;

@Component
public class MyDependency {

	//주의: formal unbound in pointcut error 발생 시 살펴 볼 내용
	//포인트컷 선언 시 사용한 변수명 intValue와 다음 메소드의 파라미터 변수명이 일치해야 한다.
	public void hello(int intValue) {
		System.out.println("hello " + intValue);
	}

	public void goodbye() {
		System.out.println("goodbye");
	}
}

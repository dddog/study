package onj.edu.aop09_10;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice{

	//중간에 파라미터 값을 가로채서 받기 위하여 aop:pointcut 태그안에 expression 속성에 추가 "and args(intValue)"
	//intValue 파라미터 변수명이 expression 속성안에 설정한 이름과 일치해야 한다.
	public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue){

		//파라미터 값에 따라 부가작업 수행 결정
		if (intValue > 5000) {
			System.out.println("충고실행 : " +
				joinPoint.getSignature().getDeclaringTypeName() + ", " +
				joinPoint.getSignature().getName());
		} else {
			System.out.println("충고실행 안 함.");
		}
	}

	public Object simpleAroundAdvice(ProceedingJoinPoint joinPoint, int intValue) throws Throwable {
		
		System.out.println();
		System.out.println("around/before " + intValue);
		Object ret = joinPoint.proceed();
		System.out.println("around/after " + intValue);
		System.out.println();
		
		return ret;
	}
}

package com.jacademy.pointcut.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

public class AopTest {
	
	@Test
	public void pointcut() throws Exception{
		targetClassPointcutMatches("execution(* *(..))", true, true, true, true, true, true, true);
		targetClassPointcutMatches("execution(* hello(..))", true, true, false, false, false, false, false);
		targetClassPointcutMatches("execution(void *(..))", true, true, false, false, true, true, true);
		//클래스에 적용되는 패턴은 이름패턴이 아니라 타입패턴이다.
		targetClassPointcutMatches("execution(* *..TargetInterface.*(..))", true, true, true, true, false, false, false);
		targetClassPointcutMatches("execution(* *..Parent.*(..))", false, false, false, false, false, false, true);
	}
	
	public void targetClassPointcutMatches(String expression, boolean...expected) throws Exception{
		//TargetInterface에 정의 된 메서드들
		pointcutMatches(expression, expected[0], Target.class, "hello");
		pointcutMatches(expression, expected[1], Target.class, "hello", String.class);
		pointcutMatches(expression, expected[2], Target.class, "plus", int.class, int.class);
		pointcutMatches(expression, expected[3], Target.class, "minus", int.class, int.class);
		
		pointcutMatches(expression, expected[4], Target.class, "method");
		pointcutMatches(expression, expected[5], Bean.class, "method");
		//Target는 Parent클래스를 상속하고 있으므로 sleep()메소드가 존재한다.
		pointcutMatches(expression, expected[6], Target.class, "sleep");
	}
	
	public void pointcutMatches(String expression, Boolean expected, Class<?> clazz, String methodName, Class<?>...args) throws Exception{
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(expression);
		
		assertThat(
				pointcut.getClassFilter().matches(clazz)
				&& pointcut.getMethodMatcher().matches(clazz.getMethod(methodName, args), null), 
				is(expected));
	}
	
	@Test
	public void methodSignature() throws NoSuchMethodException, SecurityException{
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(public int com.jacademy.pointcut.test.Target.minus(int,int) throws java.lang.RuntimeException)");
		
		assertThat(pointcut.getClassFilter().matches(Target.class), is(true));
		assertThat(pointcut.getClassFilter().matches(Bean.class), is(false));
		assertThat(pointcut.getMethodMatcher().matches(Target.class.getMethod("minus", int.class, int.class), null), is(true));
		assertThat(pointcut.getMethodMatcher().matches(Target.class.getMethod("plus", int.class, int.class), null), is(false));
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		System.out.println(Target.class.getMethod("minus", int.class, int.class));
		
//		public // 접근제한자(생략가능)
//		int  //리턴형
//		com.stararia.spring.aop.Target. //패키지.클래스명(생략가능)
//		minus //메서드명
//		(int,int) //파라미터형
//		throws java.lang.RuntimeException //예외처리형(생략가능)
	}
}

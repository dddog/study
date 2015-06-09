package oraclejava.training.aop;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsLoggingAdvice implements ThrowsAdvice {
	
	public void afterThrowing(Throwable throwable) {
		System.out.println("ThrowsLoggingAdvice.afterThrowing() 에러 발생");
	}
}

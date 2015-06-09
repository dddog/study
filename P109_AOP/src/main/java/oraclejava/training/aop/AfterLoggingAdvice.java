package oraclejava.training.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterLoggingAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		String findName = (String) args[0];
		System.out.println("AfterLoggingAdvice.afterReturning(), 가로 챈 메소드: "+method.getName() + ", 가로 챈 파라미터: " + findName);
	}

}

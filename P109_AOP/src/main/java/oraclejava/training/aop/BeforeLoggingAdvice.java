package oraclejava.training.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLoggingAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		String findName = (String) args[0];
		System.out.println("BeforeLoggingAdvice.before(), 가로 챈 메소드: "+method.getName() + ", 가로 챈 파라미터: " + findName);
	}

}

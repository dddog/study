package oraclejava.training.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String findName = (String) invocation.getArguments()[0];
		if (findName == null) {
			throw new Throwable("예외");
		}
		System.out.println("AroundLoggingAdvice.invoke(), invocation.proceed() 메소드 실행 전, 가로 챈 메소드: "+invocation.getMethod().getName() + ", 가로 챈 파라미터: " + findName);
		Object ret = invocation.proceed();
		System.out.println("AroundLoggingAdvice.invoke(), invocation.proceed() 메소드 실행 후, 가로 챈 메소드: "+invocation.getMethod().getName() + ", 가로 챈 파라미터: " + findName);
		
		//리턴 객체 제어 가능(바꿔 치기)
		return ret;
	}

}

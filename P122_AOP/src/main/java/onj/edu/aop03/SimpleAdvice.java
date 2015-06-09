package onj.edu.aop03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("SimpleAdvice의 충고가 적용 됨 : 메서드 대상 : " + invocation.getMethod().getName());
		
		Object o = invocation.proceed();
		return o;
	}

}

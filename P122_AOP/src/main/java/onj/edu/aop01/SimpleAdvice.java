package onj.edu.aop01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		System.out.println("SimpleAdvice의 충고가 적용 됨, 대상 메소드: "
				+ invocation.getClass().getSimpleName() + "."
				+ invocation.getMethod().getName());

		Object o = invocation.proceed();
		return o;
	}

}

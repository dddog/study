package onj.hello.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MsgDecorator implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// HelloWorld 클래스의 sayHello() 실행
		// 
		Object ret = invocation.proceed();
		System.out.println(" " + "OnJ");
		return ret;
	}
}
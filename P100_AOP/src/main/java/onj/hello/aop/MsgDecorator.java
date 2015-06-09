package onj.hello.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//MethodInterceptor는 메소드 호출용 어라운드 어드바이스의 표준 인터페이스
//인터페이스의 상속: Advice -- Interceptor -- MethodInterceptor
public class MsgDecorator implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//원래의 타겟 메소드 호출
		Object ret = invocation.proceed();
		//기능 추가
		System.out.println(" OnJ");
		return ret;
	}

}

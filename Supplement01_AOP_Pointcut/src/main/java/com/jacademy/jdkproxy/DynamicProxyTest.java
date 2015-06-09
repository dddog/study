package com.jacademy.jdkproxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import com.jacademy.reflection.Hello;
import com.jacademy.reflection.HelloTarget;
import com.jacademy.reflection.UppercaseHandler;

public class DynamicProxyTest {

	@Test
	public void jdkDynamicProxy(){
		Hello proxiedHello = (Hello) Proxy.newProxyInstance(
				getClass().getClassLoader(), 
				new Class[]{Hello.class}, 
				new UppercaseHandler(new HelloTarget()));
		
		assertThat(proxiedHello.sayHello("Chris"), is("HELLO CHRIS"));
	}
	
	@Test
	public void springProxyFactoryBean(){
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(new HelloTarget());
		// 타깃 오브젝트에 적용하는 부가기능을 담은 오브젝트를 어드바이스라고 부른다.
		pfBean.addAdvice(new UppercaseAdvice());
		
		Hello proxiedHello = (Hello) pfBean.getObject();
		
		assertThat(proxiedHello.sayHello("Chris"), is("HELLO CHRIS"));
	}
	
	static class UppercaseAdvice implements MethodInterceptor{

		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
			// MethodInvocation은 이미 타깃 오브젝트를 알고 있다.
			// 타깃 메소드의 호출이 필요하면 프록시로부터 전달받은 MethodInvocation 타입 콜백 오브젝트의
			// proceed() 메소드를 호출한다.
			String ret = (String) invocation.proceed();
			return ret.toUpperCase();
		}
		
	}
	
	@Test
	public void pointcutAdvisor(){
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(new HelloTarget());
		
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.setMappedName("sayH*");
		
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
		
		Hello proxiedHello = (Hello) pfBean.getObject();
		
		assertThat(proxiedHello.sayHello("Chris"), is("HELLO CHRIS"));
		assertThat(proxiedHello.sayThankYou("Chris"), is("Thank You Chris"));
	}
	
	@Test
	public void classNamePointcutAdvisor(){
		NameMatchMethodPointcut classMethodPointcut = new NameMatchMethodPointcut(){
			// 모든 클래스를 다 통과시키는 필터를 재정의
			@Override
			public ClassFilter getClassFilter() {
				return new ClassFilter() {
					
					@Override
					public boolean matches(Class<?> clazz) {
						return clazz.getSimpleName().startsWith("HelloT");
					}
				};
			}
		};
		
		classMethodPointcut.setMappedName("sayH*");
		
		checkAdviced(new HelloTarget(), classMethodPointcut, true);
		
		class HelloWorld extends HelloTarget{};
		checkAdviced(new HelloWorld(), classMethodPointcut, false);
		
		class HelloToby extends HelloTarget{};
		checkAdviced(new HelloToby(), classMethodPointcut, true);
	}

	private void checkAdviced(Object target,
			Pointcut pointcut, boolean adviced) {
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(target);
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
		
		Hello proxiedHello = (Hello) pfBean.getObject();
		
		if (adviced) {
			assertThat(proxiedHello.sayHello("Xman"), is("HELLO XMAN"));
		} else {
			assertThat(proxiedHello.sayHello("Xman"), is("Hello Xman"));
		}
		
	}
}

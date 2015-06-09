package onj.edu.aop01;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut{

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		//First 클래스에 one 메소드만 충고를 적용
		return targetClass == First.class && "one".equals(method.getName());
	}

}

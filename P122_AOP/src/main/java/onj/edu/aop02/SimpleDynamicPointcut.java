package onj.edu.aop02;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut{

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		if (args.length > 0 && args[0] instanceof Integer) {
			int i = ((Integer) args[0]).intValue();
			
			return i > 100;
		}
		
		//아규먼트가 없는 경우 모두 true를 리턴: two() 메소드도 대상이 된다.
		return true;
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			
			@Override
			public boolean matches(Class<?> clazz) {
				return clazz == First.class;
			}
		};
	}

}

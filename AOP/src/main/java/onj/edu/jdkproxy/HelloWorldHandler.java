package onj.edu.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldHandler implements InvocationHandler {
	private Object targetObj = null;

	public HelloWorldHandler(Object target) {
		this.targetObj = target;
	}

	public Object invoke(Object obj, Method method, Object[] args)
			throws Throwable {
		System.out.println(targetObj);
//		System.out.println(obj);
		System.out.println("method name : " + method.getName());
		return method.invoke(targetObj, args);
	}
}
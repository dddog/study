package onj.edu.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//java.lang.reflect.InvocationHandler 자바가 제공하는 클래스
public class HellowWorldHandler implements InvocationHandler{

	private Object targetObj;
	
	public HellowWorldHandler(Object targetObj) {
		this.targetObj = targetObj;
	}
	
	@Override
	public Object invoke(Object obj, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("BEGIN " + targetObj.getClass() + " : " + method.getName());
		
		Object ret = method.invoke(targetObj, args);
		
		System.out.println("END " + targetObj.getClass() + " : " + method.getName());
		
		return ret;
	}

}

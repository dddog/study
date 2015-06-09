package com.jacademy.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UppercaseHandler implements InvocationHandler{

	Hello target;
	
	public UppercaseHandler(Hello target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//String ret = (String) method.invoke(target, args);
		//return ret.toUpperCase();
		
		// TODO: 리턴타입이 여러가지 일 때 처리하는 방법은?
		/*
		Object ret = (String) method.invoke(target, args);
		if (ret instanceof String) {
			return ((String) ret).toUpperCase();
		} else {
			return ret;
		}
		*/
		
		// TODO: 메소드 선별기능 추가
		Object ret = (String) method.invoke(target, args);
		if (ret instanceof String && method.getName().startsWith("say")) {
			return ((String) ret).toUpperCase();
		} else {
			return ret;
		}
	}

}

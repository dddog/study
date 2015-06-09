package com.jacademy.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMain8 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		String name = "홍길동";
		System.out.println(name.length());
		System.out.println("-------------------------------");
		
		Class<? extends String> c = name.getClass();
		Method m = c.getMethod("length", null);
		
		Constructor<? extends String> cons = c.getConstructor(new Class[]{String.class});
		Object obj = cons.newInstance("홍길동");
		
		System.out.println(m.invoke(obj, null));
		System.out.println("-------------------------------");
		
		System.out.println(name.hashCode());
		System.out.println(obj.hashCode());
		System.out.println(System.identityHashCode(name));
		System.out.println(System.identityHashCode(obj));
	}
}

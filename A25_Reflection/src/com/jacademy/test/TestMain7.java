package com.jacademy.test;

import java.lang.reflect.Method;

public class TestMain7 {

	public static void main(String[] args) throws Exception {
		
		Class<?> c = Class.forName("com.jacademy.lesson.GilDong");
		
		Object obj = c.newInstance();
		
		Method m = c.getMethod("fly", null);
		
		//Object를 GilDong으로 다운캐스팅 하지 않고(컴파일 시점에 없기 때문에 불가) 메소드를 호출하는 방법
		m.invoke(obj, null);
		
		Method m2 = c.getMethod("add", new Class[]{int.class, int.class});
		int result = (int) m2.invoke(obj, new Object[]{1, 2});
		
		System.out.println(result);
	}
}

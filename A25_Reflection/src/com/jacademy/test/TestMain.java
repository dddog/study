package com.jacademy.test;

import java.lang.reflect.InvocationTargetException;

import com.jacademy.lesson.GilDong;

public class TestMain {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		GilDong gd = new GilDong("홍", "길동");
		
		System.out.println(gd.getFamilyName()+gd.getName());
		gd.fly();
		System.out.println("-------------------------");
		
		//클래스의 메타정보를 관리하는 클래스: 클래스의 정보를 분석하기 위한 도구
		Class<GilDong> c = GilDong.class;
		
		String name = c.getName();
		System.out.println(name);
		
		//디폴트 생성자를 사용
//		Object obj = c.newInstance();
//		System.out.println(obj);
		
		Object obj = c.getDeclaredConstructor(String.class, String.class).newInstance("Hong", "GilDong");
		System.out.println(obj);
		System.out.println("-------------------------");
		
		//이미 메모리의 존재하는 객체를 이용하여 클래스를 얻는다. 리플렉션
		/**
		 * 객체의 메모리만을 알고 있고, 형을 모른다면 호출이 불가능하다.
		 * 형도 알고 있지만 형변환을 할 수 없을 때 도 호출이 불가능하다.
		 */
		Class mClass = gd.getClass();
		Object mObject = mClass.newInstance();
		System.out.println(mObject);
		System.out.println("-------------------------");
	}
}

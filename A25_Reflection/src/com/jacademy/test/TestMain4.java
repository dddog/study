package com.jacademy.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.jacademy.lesson.GilDong;

public class TestMain4 {

	public static void main(String[] args) throws Exception {
		
		GilDong gd = new GilDong("홍", "길동");
		
		Class<? extends GilDong> c = gd.getClass();
		GilDong gd2 = (GilDong) c.newInstance();
		
		Method[] m = c.getMethods();
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i] + " ");
		}
		System.out.println("-----------------------------");
		
		Field[] f = c.getFields();
		for (int i = 0; i < f.length; i++) {
			System.out.println(f[i] + " ");
		}
		System.out.println("-----------------------------");
		
		Constructor<?>[] cs = c.getConstructors();
		for (int i = 0; i < cs.length; i++) {
			System.out.println(cs[i] + " ");
		}
		System.out.println("-----------------------------");
		
		Class<?>[] iface = c.getInterfaces();
		for (int i = 0; i < iface.length; i++) {
			System.out.println(iface[i] + " ");
		}
		System.out.println("-----------------------------");
		
		Class<?> sc = c.getSuperclass();
		if (sc != null) {
			System.out.println(sc + " ");
		}
		System.out.println("-----------------------------");
		
		//모든 상위 클래스 구하기
		Class<?> mClass = c;
		while ((mClass = mClass.getSuperclass()) != null) {
			System.out.println(mClass);
		}
		
	}
}

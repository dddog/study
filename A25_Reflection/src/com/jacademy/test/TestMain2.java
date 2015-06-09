package com.jacademy.test;

import com.jacademy.lesson.GilDong;

public class TestMain2 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		GilDong gd = new GilDong();
		GilDong gd2 = gd;
		
		Class c = gd.getClass();
		Object obj = c.newInstance();
		Object obj2 = c.newInstance();
		
		System.out.println(gd);
		System.out.println(gd2);
		System.out.println(obj);
		System.out.println(obj2);
		
	}
}

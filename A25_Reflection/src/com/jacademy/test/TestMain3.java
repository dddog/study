package com.jacademy.test;

import java.lang.reflect.InvocationTargetException;

import com.jacademy.lesson.GilDong;

public class TestMain3 {

	public static void main(String[] args) throws Exception {
		
		GilDong gd = new GilDong("홍", "길동");
		
		GilDong gd2 = (GilDong) gd.getClass().newInstance();
		GilDong gd3 = (GilDong) gd.getClass().getDeclaredConstructor(String.class, String.class).newInstance("일", "지매");
		
		System.out.println(gd);
		System.out.println(gd2);
		
		System.out.println(gd.getFamilyName()+gd.getName());
		System.out.println(gd2.getFamilyName()+gd2.getName());
		System.out.println(gd3.getFamilyName()+gd3.getName());
	}
}

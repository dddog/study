package com.jacademy.test;

import com.jacademy.lesson.GilDong;

public class TestMain5 {

	public static void main(String[] args) throws Exception {
		
		//1. 프로그래머: 클래스를 메모리에 올리는 코드
		GilDong gd = new GilDong("홍", "길동");
		
		System.out.println(gd.getClass().getSimpleName());
		System.out.println("------------------------");
		
		//2. VM: 클래스를 메모리에 올리는 과정
		Class c = GilDong.class;
		Object obj = c.newInstance();
		GilDong gd2 = (GilDong) obj;
		
		/**
		 * 1과 2는 같은 결과
		 */
		System.out.println("------------------------");
		
		Object gd3 = new GilDong("홍", "길동");
		System.out.println("gd3의 실체는 무엇: " + gd3.getClass().getSimpleName());
		System.out.println("------------------------");
	}
}

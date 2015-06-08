package com.jacademy.lesson;

public class Superman {
	
	private static Superman superman = new Superman();

	private Superman() {}
	
	public static Superman getInstance(){
		return superman;
	}
}

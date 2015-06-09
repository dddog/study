package com.jacademy.lesson;

public class GilDong extends HongFamily implements Fliable {

	private final String name;

	public GilDong() {
		this("Hong", "GilDong");
	}
	
	public GilDong(String familyName, String name) {
		super(familyName);
		this.name = name;
	}

	@Override
	public void fly() {
		System.out.println(familyName + name + "이(가) 날라다닌다.");
	}

	public String getName() {
		return name;
	}

	public int add(int a, int b){
		return a + b;
	}
}

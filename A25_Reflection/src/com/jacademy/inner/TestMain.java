package com.jacademy.inner;

public class TestMain {

	private class FruitAdapter{
		
		private class FruitType{
			private static final int FRUIT_WITH_IMAGE = 1;
			private static final int FRUIT_NO_IMAGE = 2;
		}
	}
	
	public void init(){
		int a = FruitAdapter.FruitType.FRUIT_WITH_IMAGE;
		//FruitType.FRUIT_WITH_IMAGE 이라고 사용하기 위해서는
		//FruitAdapter를 독립적인 클래스로 분리해야 한다.
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		
		TestMain tm = new TestMain();
		tm.init();
	}
}

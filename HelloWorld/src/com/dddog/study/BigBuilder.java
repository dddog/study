package com.dddog.study;

public class BigBuilder implements BuilderMaker{

	
	@Override
	public Builder build() {
		System.out.println("Big Build..");
		Builder builder = new Builder("Big");
		return builder;
	}


}

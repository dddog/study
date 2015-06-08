package com.dddog.study;

public class SmallBuilder implements BuilderMaker{

	private Builder builder;
	
	@Override
	public Builder build() {
		System.out.println("Small Build..");
		Builder builder = new Builder("Small");
		return builder;
	}

}

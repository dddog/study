package com.dddog.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Constructor {

	@Autowired
	@Qualifier("bigBuilder")
	private BuilderMaker builder;

	public Constructor() {
		
	}
	
	public BuilderMaker getBuilder() {
		return builder;
	}

	public void setBuilder(BuilderMaker builder) {
		this.builder = builder;
	}
	
	public void order() {
		this.builder.build();
	}
}

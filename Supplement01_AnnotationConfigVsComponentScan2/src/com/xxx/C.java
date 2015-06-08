package com.xxx;

import org.springframework.stereotype.Component;

@Component
public class C {
	public C() {
		System.out.println("creating bean C: " + this);
	}
}

package com.jacademy.sample;

import java.lang.reflect.Method;

@UserAnnotation(number = 0)
public class UserAnnotationSample {

	@UserAnnotation(number = 1)
	public static void main(String[] args) {
		
		UserAnnotationSample sample = new UserAnnotationSample();
		sample.checkAnnotations(UserAnnotationSample.class);
		
	}

	@UserAnnotation(number = 2, text = "Second text")
	public void annotationSample2() {
		//
	}

	@UserAnnotation(number = 3, text = "Third text")
	public void annotationSample3() {
		//
	}

	@UserAnnotation(number = 4, text = "Fourth text")
	public void annotationSample4() {
		//
	}

	public void checkAnnotations(Class<UserAnnotationSample> clazz) {
		
		Method[] methods = clazz.getDeclaredMethods();
		
		for (Method m : methods) {
			UserAnnotation annotation = m.getAnnotation(UserAnnotation.class);
			
			if (annotation != null) {
				int number = annotation.number();
				String text = annotation.text();
				
				System.out.println(m.getName() + ": " + number + ", " + text);
			} else {
				System.out.println(m.getName() + ": annotation is null");
			}
		}
		
	}
}

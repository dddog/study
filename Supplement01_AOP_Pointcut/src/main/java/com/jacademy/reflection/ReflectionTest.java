package com.jacademy.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReflectionTest {
	
	@Test
	public void invokeMethod() throws Exception{
		String name = "Spring";
		System.out.println(name.charAt(0));
		
		assertThat((Character)String.class.getMethod("charAt", int.class).invoke(name, 0), is('S'));
	}

	public static void main(String[] args) {
		String name = "Spring";
		
		System.out.println(name.length());
		
		Class<? extends String> clazz = name.getClass();
		try {
			Method lengthMethod = clazz.getMethod("length");
			
			System.out.println(lengthMethod);
			System.out.println(lengthMethod.invoke(name));
			
			System.out.println(String.class.getMethod("length").invoke(name));
			
			// name.length() == String.class.getMethod("length").invoke(name)
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}

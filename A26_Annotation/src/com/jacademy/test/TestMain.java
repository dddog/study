package com.jacademy.test;

import java.lang.reflect.Field;
import java.util.Vector;

import com.jacademy.person.GilDong;
import com.jacademy.person.Person;

public class TestMain {

	//컴파일러의 경고를 제거
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		GilDong gd = new GilDong("길동");
		
		//사용하지 말 것을 권고 함
		gd.sleep();
		System.out.println("---------------------------");
		
		Vector<Object> results = getObjectIdFromField(gd);
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}
		System.out.println("---------------------------");
		
		
	}
	
	public static Vector<Object> getObjectIdFromField(Object entity) throws IllegalArgumentException, IllegalAccessException {
        
		Vector<Object> results = new Vector<Object>();
		
        Class<? extends Object> clazz = entity.getClass();
        
        for (Field field : clazz.getDeclaredFields()) {
        	
            if (field.getAnnotation(Person.class) != null) {
            	//remove protection from a private field
                field.setAccessible(true);
                Object value = field.get(entity);
                
                results.add(value);
            }
        }
        
        return results;
    }
}

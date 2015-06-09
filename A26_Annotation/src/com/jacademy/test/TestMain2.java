package com.jacademy.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.jacademy.person.HongFamily;
import com.jacademy.person.MyAnnotation;

public class TestMain2 {

	public static void main(String[] args) throws Exception {
		
		HongFamily hf = new HongFamily();
		
		Map<String, HashMap<String, Object>> results = getObject(hf);
		for (Entry<String, HashMap<String, Object>> e : results.entrySet()) {
			String key = e.getKey();
			System.out.println(key);
			System.out.println("-----------------------------");
			
			HashMap<String, Object> m = results.get(key);
			for (Entry<String, Object> entry : m.entrySet()) {
				if (entry.getValue() instanceof String[]) {
					String[] newNames = (String[]) entry.getValue();
					System.out.print(entry.getKey() + ":");
					for (String string : newNames) {
						System.out.print(string + ",");
					}
					System.out.println();
				} else {
					System.out.println(entry.getKey() + ":" + entry.getValue());
				}
			}
			System.out.println("-----------------------------");
		}
		
	}
	
	public static Map<String, HashMap<String, Object>> getObject(Object entity) throws IllegalArgumentException, IllegalAccessException {
        
		Map<String, HashMap<String, Object>> results = new HashMap<String, HashMap<String, Object>>();
		
        Class<? extends Object> clazz = entity.getClass();
        
        if (clazz.getAnnotation(MyAnnotation.class) != null) {
        	
        	String className = clazz.getSimpleName();
        	MyAnnotation anno = clazz.getAnnotation(MyAnnotation.class);
        	
        	HashMap<String, Object> map = new HashMap<String, Object>();
        	map.put("value", anno.value());
        	map.put("name", anno.name());
        	map.put("age", anno.age());
        	map.put("newNames", anno.newNames());
        	
        	results.put(className, map);
		}
        
        return results;
    }
}

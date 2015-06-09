package com.jacademy.person;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
//	ElementType.ANNOTATION_TYPE, //can only be used to annotate other annotations
	ElementType.TYPE, //class, interface, enum or annotation
	ElementType.METHOD, 
	ElementType.FIELD,
	ElementType.CONSTRUCTOR
})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	
	//자료형
	String value() default "123";
	String name();
	int age();
	String[] newNames();
}

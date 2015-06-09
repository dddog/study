package com.jacademy.sample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//JDK 5 부터 등장
//Compiler instructions
//Build-time instructions
//Runtime instructions

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnotation {

	public int number();
    public String text() default "Default text";
}

package com.jacademy.aopquiz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

	public void simpleBeforeAdvice(JoinPoint joinPoint){

		System.out.println("Before..");
	}

	public Object simpleAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println();
		System.out.println("around/before ");
		Object ret = joinPoint.proceed();
		System.out.println("around/after ");
		System.out.println();
		
		return ret;
	}
}

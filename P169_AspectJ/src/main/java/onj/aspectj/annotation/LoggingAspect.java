package onj.aspectj.annotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	//사전충고: 메소드 실행전 충고 실행
	@Before("execution(* onj.aspectj.annotation.Emp.addEmp(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Advice --> logBefore() : " + joinPoint.getSignature().getName());
	}

	//사후충고: 오류가 나더라도 메소드 호출 후 실행
	@After("execution(* onj.aspectj.annotation.Emp.addEmp(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("Advice --> logAfter() : " + joinPoint.getSignature().getName());
	}

	//사후충고: 오류가 나지않고 정상적으로 리턴되어야 메소드 호출 후 실행
	@AfterReturning(pointcut = "execution(* onj.aspectj.annotation.Emp.addEmpReturnVal(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("Advice --> logAfterReturning() : " + joinPoint.getSignature().getName());
		
		//정상적으로 처리되어 메소드 addEmpReturnVal()가 리턴한 값을 얻어서 확인한다.
		System.out.println("return value is " + result);
	}

	//주변충고
	@Around("execution(* onj.aspectj.annotation.Emp.addEmpAround(..))")
	public Object stringLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Advice --> stringLogAround() : before : " + joinPoint.getSignature().getName());
		
		//타겟 메소드가 리턴하는 String name 아규먼트를 얻어서 출력한다.
		System.out.println("args : " + Arrays.toString(joinPoint.getArgs()));
		
		joinPoint.proceed();
		
		System.out.println("Advice --> stringLogAround() : after : " + joinPoint.getSignature().getName());
		
		return "리턴이 대체됨";
	}

	//예외충고
	@AfterThrowing(pointcut = "execution(* onj.aspectj.annotation.Emp.addEmpThrowException(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("Advice --> logAfterThrowing() : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
	}
}

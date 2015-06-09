package onj.aspectj.annotation3;

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
public class SmallMartAspect {

	@Before("execution(* onj.aspectj.annotation3.SmallMart.getProducts(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("사전충고 --> logBefore(): "
				+ joinPoint.getSignature().getName());
	}

	@After("execution(* onj.aspectj.annotation3.SmallMart.getProducts(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("사후충고 --> logAfter(): "
				+ joinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut = "execution(* onj.aspectj.annotation3.SmallMart.getProducts(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("사후 리터닝충고 --> logAfterReturning(): "
				+ joinPoint.getSignature().getName());
		System.out.println("return value is " + result);
	}

	@Around("execution (* onj.aspectj.annotation3.SmallMart.getProducts(..))")
	public String logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("-------------------------------------------");
		System.out.println("주변충고--> logAround(): " + joinPoint.getSignature().getName());
		System.out.println("가로 챈 아큐먼트: " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("Around before is running!");
		System.out.println("-------------------------------------------");
		
		String s = (String) joinPoint.proceed();
		
		System.out.println("-------------------------------------------");
		System.out.println("Around after is running!");
		System.out.println("-------------------------------------------");
		
		return "이 문장으로 원래 타겟메소드 리턴이 대체됨";
	}

	@AfterThrowing(pointcut = "execution (* onj.aspectj.annotation3.SmallMart.getProducts(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("예외충고--> logAfterThrowing(): "
				+ joinPoint.getSignature().getName());
		System.out.println("Exception " + error);
	}
}

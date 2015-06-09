package onj.edu.aop11;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect //클래스를 사용하여 AOP 적용대상을 설정한다.
public class MyAdvice{

	//@AspectJ는 &&, aop 네임스페이스는 and를 사용
	@Pointcut("execution(* onj.edu.aop11..hello*(int)) && args(intValue)")
	public void helloExec(int intValue){}
	
	@Pointcut("bean(myDependency*)")
	public void inMyDependency(){}
	
	@Before("helloExec(intValue) && inMyDependency()")
	public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue){
		
		if (intValue > 5000) {
			System.out.println("충고실행 : " +
					joinPoint.getSignature().getDeclaringTypeName() + ", " +
					joinPoint.getSignature().getName());
		} else {
			System.out.println("충고 실행 안함");
		}
	}

	@Around("helloExec(intValue) && inMyDependency()")
	public Object simpleAroundAdvice(ProceedingJoinPoint joinPoint, int intValue) throws Throwable {
		
		System.out.println();
		System.out.println("around/before " + intValue);
		Object ret = joinPoint.proceed();
		System.out.println("around/after " + intValue);
		System.out.println();
		
		return ret;
	}
}

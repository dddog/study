package onj.edu.aop02;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutExam {

	public static void main(String[] args) {
		
		First f = new First();
		Second s = new Second();
		
		First proxyFirst;
		Second proxySecond;
		
		Pointcut pc = new SimpleDynamicPointcut();
		//MethodInterceptor
		Advice advice = new SimpleAdvice();
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(f);
		
		proxyFirst = (First) pf.getProxy();
		
		//넘기는 파라미터 값의 의한 동적 어드바이스 적용
		proxyFirst.one(100);
		proxyFirst.one(101);
		proxyFirst.two();
				
		
		pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(s);
		
		proxySecond = (Second) pf.getProxy();
		
		proxySecond.one();
		proxySecond.two();
	}
}

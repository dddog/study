package onj.edu.aop01;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutExam {

	public static void main(String[] args) {
		
		First f = new First();
		Second s = new Second();
		
		First proxyFirst;
		Second proxySecond;
		
		//StaticMethodMatcherPointcut 상속
		Pointcut pc = new SimpleStaticPointcut();
		
		//MethodInterceptor 구현
		Advice advice = new SimpleAdvice();
		
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(f);
		
		proxyFirst = (First) pf.getProxy();
		
		proxyFirst.one();
		proxyFirst.two();
		
		
		pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(s);
		
		proxySecond = (Second) pf.getProxy();
		
		proxySecond.one();
		proxySecond.two();
	}
}

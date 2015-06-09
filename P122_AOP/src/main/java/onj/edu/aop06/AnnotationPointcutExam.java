package onj.edu.aop06;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationPointcutExam {

	public static void main(String[] args) {
		
		First f = new First();
		Second s = new Second();
		
		First proxyFirst;
		Second proxySecond;
		
		AnnotationMatchingPointcut pc = 
				AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
		
		Advice advice = new SimpleAdvice();
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(f);
		
		proxyFirst = (First) pf.getProxy();
		
		proxyFirst.hello1();
		proxyFirst.hello2();
		proxyFirst.sayHello();
		
		
		pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(s);
		
		proxySecond = (Second) pf.getProxy();
		
		proxySecond.one();
		proxySecond.two();
	}
}

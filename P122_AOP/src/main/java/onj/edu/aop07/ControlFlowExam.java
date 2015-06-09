package onj.edu.aop07;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowExam {

	public static void main(String[] args) {
		ControlFlowExam c = new ControlFlowExam();
		c.go();
	}

	private void go() {
		
		First f = new First();
		Second s = new Second();
		
		First proxyFirst;
		Second proxySecond;
		
		//ControlFlowPointcut: 특정 메소드 하위의 모든 메소드 호출 또는 특정 클래스 하위의 모든 메소드 호출에 사용한다
		//ControlFlowExam.class의 myAdvice()가 호출하는 모든메소드에 충고적용
		Pointcut pc = 
				new ControlFlowPointcut(ControlFlowExam.class, "myAdvice");
		
		Advice advice = new SimpleBeforeAdvice();
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
		
		myAdvice(proxyFirst);
	}

	private void myAdvice(First proxyFirst) {
		System.out.println("--------------------------");
		proxyFirst.hello1();
		proxyFirst.hello2();
	}
}

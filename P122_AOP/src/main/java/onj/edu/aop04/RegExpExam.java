package onj.edu.aop04;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class RegExpExam {

	public static void main(String[] args) {
		
		First f = new First();
		Second s = new Second();
		
		First proxyFirst;
		Second proxySecond;
		
		JdkRegexpMethodPointcut pc = new JdkRegexpMethodPointcut();
		//.* 모든 패키지.클래스
		//hello로 시작하는
		//.* 모드 메소드
		pc.setPattern(".*hello.*");
		
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

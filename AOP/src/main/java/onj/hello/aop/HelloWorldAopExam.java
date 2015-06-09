package onj.hello.aop;

import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAopExam {
	public static void main(String[] args) {
		HelloWorld target = new HelloWorld();
		// Proxy 생성
		ProxyFactory pf = new ProxyFactory();
		// 어드바이스를 추가
		pf.addAdvice(new MsgDecorator());
		// 위빙할 타겟을 정의
		pf.setTarget(target);
		// 프록시 생성
		HelloWorld proxy = (HelloWorld) pf.getProxy();
		// HelloWorld의 sayHello()호출
		//target.sayHello();
		// 프록시의 sayHello 호출
		proxy.sayHello();
	}
}
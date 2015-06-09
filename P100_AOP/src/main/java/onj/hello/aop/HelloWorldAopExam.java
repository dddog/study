package onj.hello.aop;

import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAopExam {

	public static void main(String[] args) {
		HelloWorld target = new HelloWorld();
		
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(new MsgDecorator());
		
		HelloWorld proxy = (HelloWorld) pf.getProxy();
		//Spring AOP는 메소드 가로채기로 제한
		proxy.sayHello();
		
		target.sayHello();
		
		//예외 발생: 
		//Cannot proxy target class because CGLIB2 is not available. 
		//Add CGLIB to the class path or specify proxy interfaces.
		//해결: pom.xml에 다음 코드 추가
		/*
		<dependency>
			<groupId>cglib</groupId>
			<artifactId>cglib</artifactId>
			<version>2.2.2</version>
		</dependency>
		*/
	}
}

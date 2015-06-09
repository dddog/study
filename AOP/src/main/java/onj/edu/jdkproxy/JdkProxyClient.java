package onj.edu.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * 객체의 메쏘드를 호출할 때 직접 객체를 호출하는 방식이 아니라, HelloHandler라는 프록시 객체를 이용하는 방식이다.
 * HelloHandler는 invoke라는 메쏘드를 통해서 지정된 객체의 함수를 실행하는데
 */
public class JdkProxyClient {
	public static void main(String[] args) {
		try {
			Class[] arrClass = { HelloWorld.class };
			// HelloWorldHandler에는 target 객체를 인자로 넣어준다.
			HelloWorldHandler handler = new HelloWorldHandler(
					new HelloWorldImpl());
			
			/*
			 * 프록시객체를 직접만드는 것이 아니라 프로그램적으로 생성한다.
			 * InvocationHandler핸들러를 대신 만들고 이를 이용하여 프로그램적으로 생성한다.
			 */
			HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(
					HelloWorld.class.getClassLoader(), arrClass, handler);
			
			proxy.sayHello("your name...");
			proxy.sayHi("dddog");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
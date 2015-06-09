package onj.edu.jdkproxy;

import java.lang.reflect.Proxy;

public class JdkProxyClient {

	public static void main(String[] args) {
		try {
			Class[] arrClass = {HelloWorld.class};
			
			//생성자를 통해 타겟 클래스를 지정
			HellowWorldHandler handler = new HellowWorldHandler(new HelloWorldImpl());
			
			HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(
					HelloWorld.class.getClassLoader(), 
					arrClass, //인터페이스
					handler);
			
			//인터페이스에 있는 메서드 호출
			proxy.sayHello("Chris");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

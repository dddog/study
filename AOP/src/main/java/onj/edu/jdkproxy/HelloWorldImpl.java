package onj.edu.jdkproxy;

public class HelloWorldImpl implements HelloWorld {
	
	@Override
	public void sayHello(String msg) {
		System.out.println("오라클자바에 오신 것을 환영 합니다.... " + msg);
	}

	@Override
	public void sayHi(String msg) {
		System.out.println("Hi "+msg);
	}
}
package onj.edu.jdkproxy;

public class HelloWorldImpl implements HelloWorld{

	@Override
	public void sayHello(String msg) {
		System.out.println("Hello " + msg);
	}

}

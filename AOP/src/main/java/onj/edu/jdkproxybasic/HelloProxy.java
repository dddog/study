package onj.edu.jdkproxybasic;

public class HelloProxy implements Hello{

	private Hello hello;
	public HelloProxy(Hello hello) {
		this.hello = hello;
	}
	
	public void say() {
		System.out.println("----------start-----------");
		//Delegation(위임)
		hello.say();
		System.out.println("----------e n d-----------");
	}
}

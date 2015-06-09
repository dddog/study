package onj.edu.aop06;

public class First {

	@AdviceRequired
	public void hello1() {
		System.out.println("First.hello1() called");
	}

	public void hello2() {
		System.out.println("First.hello2() called");
	}

	@AdviceRequired
	public void sayHello() {
		System.out.println("First.sayHello() called");
	}
}

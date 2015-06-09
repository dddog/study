package onj.edu.jdkproxybasic;

public class HelloTarget implements Hello{

	
	@Override
	public void say() {
		System.out.println("Hello~!!");
	}
}

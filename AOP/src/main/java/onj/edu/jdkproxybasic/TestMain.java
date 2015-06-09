package onj.edu.jdkproxybasic;

public class TestMain {

	public static void main(String[] args) {
		Hello target = new HelloTarget();
		
		target.say();
		
		System.out.println("**************************");
		
		Hello proxy = new HelloProxy(target);
		proxy.say();
		
		
	}
}

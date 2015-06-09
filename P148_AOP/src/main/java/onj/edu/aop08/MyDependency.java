package onj.edu.aop08;

public class MyDependency {

	//execution(* hello*(..))의 대상
	public void hello() {
		System.out.println("hello");
	}

	public void goodbye() {
		System.out.println("goodbye");
	}
}

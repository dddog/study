package onj.edu.aop08;

public class MyBean {

	private MyDependency dependency;
	
	public void run(){
		dependency.hello();
		dependency.goodbye();
	}
	
	public void setDependency(MyDependency dependency){
		this.dependency = dependency;
	}
}

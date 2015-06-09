package onj.edu.aop09_10;

public class MyBean {

	private MyDependency dependency;
	
	public void run(){
		dependency.hello(5919);
		dependency.hello(4790);
		dependency.hello2(5001);
		dependency.goodbye();
	}
	
	public void setDependency(MyDependency dependency){
		this.dependency = dependency;
	}
}

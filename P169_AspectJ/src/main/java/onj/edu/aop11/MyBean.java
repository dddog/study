package onj.edu.aop11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

	@Autowired
	private MyDependency myDependency;
	
	public void run(){
		myDependency.hello(5919);
		myDependency.hello(4790);
		myDependency.goodbye();
	}
}

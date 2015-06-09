package onj.edu.aop11;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExam2 {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("aop-context11.xml");
		ctx.refresh();
		
		MyBean bean = (MyBean) ctx.getBean("myBean");
		
		System.out.println("---- myBean ----");
		bean.run();
		
		ctx.close();
	}
}

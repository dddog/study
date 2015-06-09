package onj.edu.aop09_10;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExam {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("aop-context9.xml");
		ctx.refresh();
		
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		
		System.out.println("---- myBean ----");
		myBean.run();
		
		ctx.close();
	}
}

package onj.edu.aop08;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProxyFactoryBeanExam {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("aop-context8.xml");
		ctx.refresh();
		
		MyBean myBean1 = (MyBean) ctx.getBean("myBean1");
		MyBean myBean2 = (MyBean) ctx.getBean("myBean2");
		
		System.out.println("---- myBean1 ----");
		myBean1.run();
		System.out.println("---- myBean2 ----");
		myBean2.run();
		
		ctx.close();
	}
}

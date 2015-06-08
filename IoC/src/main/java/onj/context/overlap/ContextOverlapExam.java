package onj.context.overlap;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ContextOverlapExam {
	public static void main(String[] args) {
		GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
		parent.load("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		parent.refresh();
		
		GenericXmlApplicationContext child = new GenericXmlApplicationContext();
		child.load("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
		child.setParent(parent);
		child.refresh();
		
		Onj target1 = (Onj) child.getBean("target1");
		Onj target2 = (Onj) child.getBean("target2");
		String target3 = (String) child.getBean("parent2");
		
		System.out.println(target1.getVal1());
		System.out.println(target2.getVal2());
		System.out.println(target3);
	}
}
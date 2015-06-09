package onj.aspectj.annotation3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJAnnotationExam3 {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aspectjannotation3.xml");
		
		SmallMart sm = (SmallMart) ctx.getBean("smallMart");
		System.out.println("최종결과 : "+ sm.getProducts("상품"));
	}
}

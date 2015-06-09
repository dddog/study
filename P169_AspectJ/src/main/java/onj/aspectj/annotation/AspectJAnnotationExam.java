package onj.aspectj.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJAnnotationExam {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aspectjannotation.xml");
		
		Emp e = (Emp) ctx.getBean("emp");
		e.addEmp();
		System.out.println("--------------");
		
		e.addEmpReturnVal();
		System.out.println("--------------");
		
		String name = e.addEmpAround("오라클자바");
		System.out.println("최종결과: " + name);
		System.out.println("--------------");
		
		try {
			e.addEmpThrowException();
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("예외 처리 로직으로 알맞게 처리한다.");
		}
		
	}
}

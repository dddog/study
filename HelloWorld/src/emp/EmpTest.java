package emp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"emp/emp.xml");
		Emp emp = (Emp) ctx.getBean("emp");
		emp.work();
	}
}
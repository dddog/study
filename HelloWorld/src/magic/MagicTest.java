package magic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MagicTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"magic/magic.xml");
		Magician magician = (Magician) ctx.getBean("magician");
		magician.magic();
	}
}
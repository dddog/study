package oraclejava.training.aop;

import org.springframework.aop.framework.ProxyFactory;

public class SmallMartApp {

	public static void main(String[] args) {
		SmallMartInterface target = new SmallMart();
		
		ProxyFactory pf = new ProxyFactory();
//		pf.addAdvice(new BeforeLoggingAdvice());
//		pf.addAdvice(new AfterLoggingAdvice());
//		pf.addAdvice(new AroundLoggingAdvice());
		pf.addAdvice(new ThrowsLoggingAdvice());
		
		pf.setTarget(target);
		
		try {
			SmallMartInterface proxy = (SmallMartInterface) pf.getProxy();
			proxy.getProducts("생필품");
		} catch (Exception e) {
			System.out.println("에러 메시지가 뭐니: " + e.getMessage());
			//e.printStackTrace();
		}
	}
}

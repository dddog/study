package edu.biz.ioc.p25;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

public class OrderManagerApp {
	public static void main(String args[]) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new FileSystemResource(
				"src/edu/biz/ioc/p25/ioc.xml"));
		OrderManager manager = (OrderManager) factory.getBean("orderManager");
//		manager.setMaker(new HyundaiMaker());
		manager.order();
	}
}

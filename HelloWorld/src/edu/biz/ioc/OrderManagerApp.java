package edu.biz.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

public class OrderManagerApp {
	public static void main(String args[]) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new FileSystemResource("src/edu/biz/ioc/ioc.xml"));
		OrderManager manager = (OrderManager)factory.getBean("orderManager");
		manager.order();
	}
}

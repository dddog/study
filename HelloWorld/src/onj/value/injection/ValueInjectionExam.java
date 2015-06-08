package onj.value.injection;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ValueInjectionExam {
	private String name;
	private String age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String toString() {
		return "Your name is " + name + " age is " + age;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("onj/value/injection/app-context.xml");
		ctx.refresh();
		ValueInjectionExam exam = (ValueInjectionExam) ctx.getBean("sample");
		System.out.println(exam);
	}
}

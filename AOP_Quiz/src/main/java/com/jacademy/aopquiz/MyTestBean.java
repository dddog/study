package com.jacademy.aopquiz;

public class MyTestBean {

	Parent parent;
	Target target;
	Bean bean;
	/**
	 * @return the parent
	 */
	public Parent getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	/**
	 * @return the target
	 */
	public Target getTarget() {
		return target;
	}
	/**
	 * @param target the target to set
	 */
	public void setTarget(Target target) {
		this.target = target;
	}
	/**
	 * @return the bean
	 */
	public Bean getBean() {
		return bean;
	}
	/**
	 * @param bean the bean to set
	 */
	public void setBean(Bean bean) {
		this.bean = bean;
	}
	public void run() {
		parent.sleep();
		target.hello();
		target.hello("aaa");
		target.method();
		target.minus(1, 2);
		target.plus(1, 2);
		bean.method();
	}
}

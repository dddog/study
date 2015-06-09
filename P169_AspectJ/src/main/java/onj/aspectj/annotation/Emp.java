package onj.aspectj.annotation;

public interface Emp {

	void addEmp();
	String addEmpReturnVal();
	String addEmpAround(String name);
	void addEmpThrowException() throws Exception;
}

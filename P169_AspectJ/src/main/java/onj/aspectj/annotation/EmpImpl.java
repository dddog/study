package onj.aspectj.annotation;

public class EmpImpl implements Emp{

	@Override
	public void addEmp() {
		System.out.println("EmpImpl.addEmp() called");
	}

	@Override
	public String addEmpReturnVal() {
		System.out.println("EmpImpl.addEmpReturnVal() called");
		return "새로 만든 스트링";
	}

	@Override
	public String addEmpAround(String name) {
		System.out.println("EmpImpl.addEmpAround() called : 파라미터 : " + name);
		return name;
	}

	@Override
	public void addEmpThrowException() throws Exception {
		System.out.println("EmpImpl.addEmpThrowException() called");
		throw new Exception("새로 만들어 던진 예외");
	}

}

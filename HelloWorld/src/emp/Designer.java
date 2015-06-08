package emp;

public class Designer extends Emp {
	@Override
	public Emp getEmp() {
		return this;
	}
	
	@Override
	public void work() {
		System.out.println("디자이너가 디자읶을 합니다.");
	}
}
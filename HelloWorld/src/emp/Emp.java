package emp;

public abstract class Emp {

	public Emp() {}
	
	public void work() {
		getEmp().work();
	}
	
	//getEmp를 주입, Emp가 주입된다.
	//Run-Time중에 xml 파읷로 부터 빈을 주입받는다.
	public abstract Emp getEmp() ;
}

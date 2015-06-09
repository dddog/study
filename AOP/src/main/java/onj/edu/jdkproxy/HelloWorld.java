package onj.edu.jdkproxy;

//jdk.lang.Proxy를 이용하는 방법은 Proxy 인터페이스를 이용하여 
//객체를 생성하므로 반드시 인터페이스 필요, 인테페이스가 없는 경우 CGLIB이용 
public interface HelloWorld {
	public void sayHello(String msg);
	public void sayHi(String msg);
}
package com.jacademy.test;

public class TestMain6 {

	public static void main(String[] args) throws Exception {
		
		
		String s2 = new String("홍길동");
		String s1 = "홍길동";
		//String s1 = s2;
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s1.equals(s2));
		System.out.println("-------------------------");
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(s1 == s2);
		System.out.println("-------------------------");
		
		//정적 바인딩: 컴파일 시점에 해당 클래스를 사용할 수 있다.
		Class c1 = String.class;
		Class c2 = s1.getClass();
		
		//동적 바인딩: 컴파일 시점에 해당 클래스를 사용할 수 없다.
		//프로그램 처리의 흐름이 아래 코드에 도달 했을 때 메모리 로드를 시도한다.
		//따라서, 그 전에는 메모리에 존재하지 않으므로 다운 캐스팅을 할 수 없다.
		//추가설명: CustomString 라는 파일 자체가 컴파일 시 존재하지 않기 때문에 프로그램은 이 단어를 사용할 수 없다.
		//다운 캐스팅 할 수 없다는 것은 CustomString의 멤버 메소드를 호출할 수 없다는 것을 의미한다.
		//--> 리플렉션을 사용하여 다운캐스팅 하지 않고도 메소드를 호출 할 수 있다.
		//형을 복원할 수 없는 객체가 존재할 때 형확인을 하고, 객체를 생성하고, 메소드를 호출할 수 있는 기법
		Class c3 = Class.forName("com.goodcompany.CustomString");
		
		//컴파일 시 클래스가 존재하는 경우지만 forName() 메소드를 사용하는 예
		//사용하는 클래스가 컴파일 시점에 필요 없으므로 외부 프로퍼티 파일로 빼서 관리하면
		//재 컴파일의 번거로움 없이 로드 할 클래스를 바꿀 수 있다. 예: JDBC 오라클 드라이버 로드
	}
}

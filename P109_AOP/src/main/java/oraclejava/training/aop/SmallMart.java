package oraclejava.training.aop;

public class SmallMart implements SmallMartInterface{

	//before Advice
	@Override
	public void getProducts(String productName) throws Exception {
		System.out.println("SmallMart.getProducts(), 받은 파라미터: " + productName);
		
		// 아래 주석 풀고 테스트
		throw new Exception("직접 발생시킨 예외");
	}
	//after Advice

}

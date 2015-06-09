package onj.aspectj.annotation3;

public class SmallMartImpl implements SmallMart{

	@Override
	public String getProducts(String productName) throws Exception {
		System.out.println("타겟 메소드: SmallMartImpl.getProducts() called!");
		return "오라클자바 " + productName;
	}

}

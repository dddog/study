package edu.biz.ioc.p33;

import org.springframework.stereotype.Component;

//단순히 DTO같은 컴포넌트 클래스임을 의미
//id를 안넣으면 클래스 이름의 앞글자를 소문자로 변경한 값으로 사용
@Component("money")
public class Money {

	private int amount;
	public Money() {
		
	}
	public Money(int amt) {
		this.amount = amt;
	}
	public int getAmount() {
		return this.amount;
	}
	public void setAmount(int amt) {
		this.amount = amt;
	}
}

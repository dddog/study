package edu.biz.ioc.p33;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Commponent
 * Service는 Component의 자식 애노테이션
 * 클래스를 분류하기 위한 용으로 범주에 따라 다른 애노테이션을 붙인다.
 * 
 * Service, Respository, Component..: 빈 컨테이너에 클래스를 등록 요청
 */
@Service("hyundai")
public class HyundaiMaker implements CarMaker{
	
	/*
	 * 일치하는 자료형의 빈을 필드변수에 할당하라는 요청
	 * required=false 없으면 무시
	 */
	@Autowired(required=false)
	private Car car;
	
	public HyundaiMaker() {
		
	}
	
	@Override
	public Car sell(Money monye) {
		System.out.println("I sold a Sonata.");
		car.setName("Sonata");
		return car;
	}
}

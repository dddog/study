package com.jacademy.a02mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jacademy.a02mvc.model.Member;

@Controller
@RequestMapping("/enroll")
@SessionAttributes("member")
public class EnrollController {
	
	//org.springframework.web.HttpSessionRequiredException 예외처리
	@ModelAttribute("member")
	public Member makeForm(){
		return new Member();
	}

	@RequestMapping(params="action=one")
	public String one(){
		return "enroll/enroll_one";
	}
	
	@RequestMapping(params="action=two")
	public String two(@ModelAttribute("member") Member member){
		return "enroll/enroll_two";
	}
	
	@RequestMapping(params="action=three")
	public String three(
			@ModelAttribute("member") Member member,
			SessionStatus sessionStatus){
		
		/*
		 * 회원등록
		 */
		
		//세션에 저장한 정보가 더 이상 필요없으므로 파기
		sessionStatus.setComplete();
		
		return "enroll/enroll_result";
	}
}

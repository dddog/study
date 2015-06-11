package com.jacademy.a02mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jacademy.a02mvc.model.Login;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(method=RequestMethod.GET)
	public String loginForm(){
		return "login/login_form";
	}
	
	/*
	 * 웹 폼에서 넘어 온 값의 name이 모델 객체의 필드변수와 일치하면
	 * 자동으로 모델객체에 넣어준다.
	 */
	@RequestMapping(params="action=login")
	public String check(Login login, HttpServletRequest request){
		
		if (login.getId().equals("admin")) {
			if (login.getPw().equals("1234")) {
				
				//서버에 상관없이 HttpSession을 안전하게 사용하려면 핸들러 어댑터의
				//synchronizeOnSession 프로퍼티를 true 로 설정
				request.getSession().setAttribute("userId", "admin");
			}
		}
		return "login/login_form";
	}
	
	@RequestMapping(params="action=logout")
	public String logout(HttpServletRequest request){
		//세션 저장정보 파괴
		request.getSession().invalidate();
		
		return "login/login_form";
	}
}

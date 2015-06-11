package com.jacademy.a02mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {

	/*
	 * http://localhost:8080/a02mvc/hello
	 */
//	@RequestMapping(method=RequestMethod.GET)
	@RequestMapping
	public String hello(){
		return "hello";
	}
	
	/*
	 * RequestMapping의 중첩: 클래스 선언 + 메소드 선언
	 * http://localhost:8080/a02mvc/hello/one
	 */
	@RequestMapping(value="/one", method=RequestMethod.GET)
	public String one(){
		return "one";
	}
	
}

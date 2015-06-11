package com.jacademy.p343;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*
	 * 처리 URL 패턴
	 * http://localhost:8080/p343/hello
	 * http://localhost:8080/p343/hello/
	 * http://localhost:8080/p343/hello.do
	 * http://localhost:8080/p343/hello.html은 아래 명시적인 리퀘스트매핑이
	 * 있으므로 처리하지 않는다.
	 */
	@RequestMapping(value="/hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping(value="/hello.html")
	public String hello2(){
		return "hello2";
	}
}

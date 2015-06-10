package com.jacademy.p289;

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
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		/*
		 * 스프링이 미리 만들어 논 정보 전송용 객체 > 뷰(jsp)에게 전달된다.
		 */
		model.addAttribute("serverTime", formattedDate );
		
		// 뷰를 호출하는 코드
		/*
		 * org.springframework.web.servlet.view.InternalResourceViewResolver
		 * "/WEB-INF/views/"+"home"+".jsp"
		 */
		return "home";
	}
	
	@RequestMapping(value="/hello")
	public String first(Model model) {
		logger.info("/hello.do first");
		model.addAttribute("caller", "first");
		return "hello";
	}
	
	@RequestMapping(value="/hello.html")
	public String second(Model model) {
		model.addAttribute("caller", "second");
		return "hello";
	}
}

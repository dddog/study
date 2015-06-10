package com.jacademy.txtest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jacademy.txtest.service.EmpService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private EmpService service;
	
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
	
	@RequestMapping(value = "/check")
	public ModelAndView check(){
		return new ModelAndView("home", "service", service);
	}
	
	@RequestMapping(value = "/getEmp")
	public ModelAndView getEmp(@RequestParam("deptno") int dno){
		
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("list", service.getEmpByDeptno(dno));
		return mav;
	}
	
	@RequestMapping(value = "/insertEmp")
	public String insertEmp(Model model){
		try {
			service.insertEmps();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", e.getMessage());
		}
		return "home";
	}
	
}

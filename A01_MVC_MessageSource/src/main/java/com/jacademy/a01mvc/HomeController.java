package com.jacademy.a01mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private int count;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		System.out.println("---------------------");
		System.out.println("request.getParameter(\"redirectAttr\"): " + request.getParameter("redirectAttr"));
		System.out.println("request.getAttribute(\"redirectAttr\"): " + request.getAttribute("redirectAttr"));
		
		// FlashMap에 저장된 값을 꺼내옴
//		Map<String, ?> fm = RequestContextUtils.getInputFlashMap(request);
//		if( fm != null ) {
//			String message = (String) fm.get("redirectFlashAttr");
//			System.out.println("message>>>"+message);
//		}
		return "home";
	}
	
	@RequestMapping(value = "/changeLocale.do")
	public String changeLocale(
			@RequestParam(value = "locale") String locale,
			HttpServletRequest request,
			RedirectAttributes redirectAttr){
		
		count++;
		
		Locale loc = null;
		if (locale.equals("ko")) {
			loc = Locale.KOREAN;
		} else {
			loc = Locale.ENGLISH;
		}
		//로컬정보를 변경한다.
		request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, loc);
		
		//essentially constructs request parameters out of your attributes 
		//and redirects to the desired page with the request parameters
		redirectAttr.addAttribute("redirectAttr","First"+count);
		//actually stores the attributes in a flashmap (which is internally maintained in the users session 
		//and removed once the next redirected request gets fulfilled)
		redirectAttr.addFlashAttribute("redirectFlashAttr", "Second"+count);
		
		//특정 view가 아닌 URL로 redirect 한다.
		System.out.println("request.getHeader(\"referer\"): " + request.getHeader("referer"));
		return "redirect:" + request.getHeader("referer");
	}
}

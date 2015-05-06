package kr.co.scllab.login;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login.scl")
	public String login(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "login";
	}
}

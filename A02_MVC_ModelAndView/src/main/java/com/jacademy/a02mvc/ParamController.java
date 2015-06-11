package com.jacademy.a02mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;
import com.jacademy.a02mvc.model.Login;
import com.jacademy.a02mvc.valid.LoginValidator;

@Controller
@RequestMapping("/param")
public class ParamController {

	@RequestMapping("/test1")
	public String test1(HttpServletRequest request){
		request.setAttribute("requestKey", "requestValue");
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionKey", "sessionValue");
		
		return "param/test1";
	}
	
	// String, int와 같은 단순 타입인 경우는 @RequestParam을 아예 생략할 수도 있다.
	// 하지만, 값을 못 받으면 예외가 발생하므로 주의가 필요하다. java.lang.IllegalStateException
	// @RequestParam은 스프링의 기본 타입 변환 기능을 이용해서 요청 파라미터 값을 메소드 파라미터 타입으로 변환한다.
	@RequestMapping("/test2")
	public String test2(
			@RequestParam(value="no", required=false, defaultValue="1") int no, 
			//int no, //@RequestParam을 생략해도 받을 수 있는지 테스트 해 본다.
			Model model){
		model.addAttribute("no", no);
		
		return "param/test2";
	}
	
	@RequestMapping("/test3")
	public String test3(
			 @CookieValue(value="auth", required=false, defaultValue="NONE") String auth, 
			Model model){
		model.addAttribute("auth", auth);
		
		return "param/test3";
	}
	
	@RequestMapping("/test4")
	public String saveCookie(
			@RequestParam(value="auth", required=true) String auth, 
			Model model,
			HttpServletRequest request,
			HttpServletResponse response){
		
		/*
		 * 쿠키 저장
		 */
		Cookie cookie = new Cookie("auth", auth);
		cookie.setMaxAge(7*24*60*60);
		response.addCookie(cookie);
		
		Cookie[] cookies = request.getCookies();
		//저장 된 쿠키의 수
		System.out.println("cookies.length: " + cookies.length);
		for (Cookie c : cookies) {
			//저장 된 쿠키의 키:값
			System.out.println(c.getName() + ":" + c.getValue());
		}
		
		return "param/test4";
	}
	
	@RequestMapping("/test5")
	public String deleteCookie(HttpServletResponse response){
		/*
		 * 쿠키 삭제
		 */
		Cookie cookie = new Cookie("auth", "");
		//0으로 설정해서 만료한다.
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		return "param/test3";
	}
	
	/*
	 * @ModelAttribute 모든 뷰에게 항상 전달
	 */
	@ModelAttribute("hobbies")
	public String[] hobbies(){
		String[] hobbies = {"drinking", "soju", "beer"};
		return hobbies;
	}
		
	@RequestMapping("/test6")
	public String test6(){
		
		return "param/test6";
	}
	
	/*
	 * @ModelAttribute가 붙은 파라미터를 처리할 때는 @RequestParam 과 달리
	 * Validation 작업이 추가적으로 진행된다.
	 * 폼에 입력 받은 아이디가 모델객체의 아이디와 같다면 자동으로 담아 준다.
	 * 지정한 아이디로 모델어트리뷰트를 추가한다.
	 */
	@RequestMapping("/test7")
	public String test7(@ModelAttribute("userLogin") Login login){
		//폼에서 넘겨 준 값이 로그인 객체의 담겨있는지 확인한다. 
		System.out.println("id: " + login.getId());
		System.out.println("pw: " + login.getPw());
		
		return "param/test7";
	}
	
	@RequestMapping("/test8")
	public String test8(@ModelAttribute("userLogin") Login login){
		
		return "param/test8";
	}
	
	//BindingResult는 @ModelAttribute 파라미터 뒤에 나와야 한다. 
	//자신의 바로 앞에 있는 @ModelAttribute 파라미터의 검증 작업에서 발생한 오류만을 전달해 주기 때문이다.
	@RequestMapping("/test9")
	public String test9(
			@ModelAttribute("userLogin") Login login,
			BindingResult bindingResult,
			SessionStatus status){
		
		//유효성 검사
		//에러가 있다면 bindingResult 객체에 결과를 담아준다.
		LoginValidator valid = new LoginValidator();
		valid.validate(login, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "param/test8";
		} else {
			//컨트롤러가 제공하는 기능 중에 모델 오브젝트를 세션에 저장했다가 다음 페이지에서 
			//다시 활용하게 해주는 기능이 있다. 이 기능을 사용하다가 더 이상 세션 내에 모델 
			//오브젝트를 저장할 필요가 없을 경우에는 코드에서 직접 작업 완료 메소드를 호출해서 
			//세션안에 저장된 오브젝트를 제거해 줘야 한다.
			status.setComplete();
			
			//밸리드 체크 통과
			return "param/test9";
		}
		
	}
	
	@RequestMapping("/test10")
	@ResponseBody //뷰(jsp)를 호출하지 않고 직접 결과를 생성해서 돌려준다.
	public String test10(){
		Login login = new Login();
		login.setId("gdragon");
		login.setPw("1234");
		
		List<Login> list = new ArrayList<Login>();
		list.add(login);
		
		//객체 정보를 JSON(객체를 문자열로 표시하는 표시방법)
		return new Gson().toJson(list);
	}
}

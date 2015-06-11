package com.jacademy.a02mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/model")
public class ModelController {

	@RequestMapping("/ret_string")
	public String retString(Model model, ModelMap map){
		
		model.addAttribute("modelKey", "Model로 저장한 속성 값");
		map.addAttribute("mapKey", "ModelMap으로 저장한 속성 값");
		
		/*
		 * 폴더명/파일명
		 * 리턴된 문자열은 뷰리졸버에 의해 완성된 URL이 컨트롤러에게 전달된다.
		 */
		return "model/ret_string";
	}
	
	@RequestMapping("/ret_modelandview")
	public ModelAndView retModelAndView(){
		/*
		 * 보여 줄 뷰 문자열을 생성자의 파라미터로 알려준다.
		 */
		ModelAndView mav = new ModelAndView("model/ret_modelandview");
		mav.addObject("mavKey", "ModelAndView로 저장한 속성 값");
		
		return mav;
	}
}

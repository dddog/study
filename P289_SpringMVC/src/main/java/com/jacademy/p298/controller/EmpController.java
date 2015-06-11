package com.jacademy.p298.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jacademy.p298.dao.EmpDao;
import com.jacademy.p298.model.Emp;

@Controller
public class EmpController {

	@Resource(name="empDao")
	private EmpDao dao;
	
	@RequestMapping(value="/emp")
	public String start(Model model) {
		List<Emp> results = dao.Select();
		model.addAttribute("empList", results);
		return "emp_list";
	}
}

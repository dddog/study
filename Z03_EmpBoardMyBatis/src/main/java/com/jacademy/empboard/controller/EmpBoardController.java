package com.jacademy.empboard.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jacademy.empboard.dao.EmpDao;
import com.jacademy.empboard.dao.EmpDaoImpl;
import com.jacademy.empboard.util.Pager;
import com.jacademy.empboard.util.PagerMaker;

@Controller
public class EmpBoardController {
	private EmpDao dao = new EmpDaoImpl();
	private PagerMaker pagerMaker = new PagerMaker();

	@RequestMapping("emp_list")
	public void empList(HttpServletRequest request) {
		int showPage = 1;
		if (request.getParameter("currentPage") != null) {
			showPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		Pager pager = pagerMaker.make(showPage, 10, 5, dao.count());
		request.setAttribute("results",
				dao.selectByLimit(pager.getStart(), pager.getEnd()));
		request.setAttribute("pager", pager);
	}
}

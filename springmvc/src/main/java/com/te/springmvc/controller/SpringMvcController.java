package com.te.springmvc.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.te.springmvc.bean.UserBean;

@Controller
public class SpringMvcController {

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("homepage");
		return modelAndView;
	}

//	@RequestMapping(path = "/search", method = RequestMethod.GET)
//	public ModelAndView getData(ModelAndView modelAndView, HttpServletRequest request) {
//		String name = request.getParameter("name");
//		request.setAttribute("username", name);
//		modelAndView.setViewName("newHome");
//		return modelAndView;
//	}

//	@GetMapping("/login")
//	public String getForm() {
//		return "login";
//
//	}
//
//	@PostMapping("/login")
//	public String getFormData(HttpServletRequest request, ModelMap modelmap) {
//
//		String name = request.getParameter("user");
//		int password = Integer.parseInt(request.getParameter("pwd"));
//		modelmap.addAttribute("name", name);
//		modelmap.addAttribute("pwd", password);
//		return "userDetails";
//
//	}
//
//	@PostMapping("/login1")
//	public String name(ModelMap modelMap, int pwd, String user) {
//		modelMap.addAttribute("name", user);
//		modelMap.addAttribute("pwd", pwd);
//		return "userDetails";
//	}
//
//	@PostMapping("/login2")
//	public String getDataFromBean(UserBean bean, ModelMap modelMap) {
//		modelMap.addAttribute("name",bean.getUser() );
//		modelMap.addAttribute("pwd", bean.getPwd());
//		
//		return "userDetails";
//	}
	
	@PostMapping("/login3")
	public String  getformRequestParram( ModelMap modelMap,
			@RequestParam(name="")String user,
	        @RequestParam(name="")int pwd
			) {
		modelMap.addAttribute("name",user);
		modelMap.addAttribute("pwd",pwd);
		
		return "userDetails";
	}
	
	

}

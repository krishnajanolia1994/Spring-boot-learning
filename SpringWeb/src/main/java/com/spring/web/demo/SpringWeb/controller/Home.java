package com.spring.web.demo.SpringWeb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.demo.SpringWeb.model.Alien;

@Controller
public class Home {
	
	//the commented line is valid code 

//	@GetMapping("home")
//	public String home(HttpServletRequest req, HttpServletResponse res) {
//		
//		HttpSession session = req.getSession();
//		String name =  req.getParameter("name");
//		System.out.println(name);
//		session.setAttribute("name",name);
//		
//		return "index";
//	}
	
	
	@GetMapping("home")
	public ModelAndView home(@RequestParam("name") String  myName) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("index");
		modelAndView.addObject("name", myName);
		return modelAndView;
	}
	
	@GetMapping("alien")
	public ModelAndView alien(Alien alien){
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("index");
		modelAndView.addObject("alien", alien);
		return modelAndView;
	}
}

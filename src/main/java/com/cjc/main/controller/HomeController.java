package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.model.Student;
import com.cjc.main.service.HomeService;

@Controller
@Component
@Configuration
public class HomeController
{

	@Autowired
	HomeService hs;
	

	@RequestMapping("/")
	public String prelogin()
	{
		System.out.println("PreLogin Page");
		return "login";
	}
	
	@RequestMapping("/registration")
	public String preRegister()
	{
		
		return "registration";
	}
	
	@RequestMapping("/reg")
	public String registerData(@ModelAttribute Student s)
	{
		hs.saveData(s);
		return "login";
	}
	
	@RequestMapping("/login")
	public String logincheck(@RequestParam("uname") String uname, @RequestParam("password") String ps,Model m)
	{
		
		hs.loginCheck(uname,ps);
		Iterable<Student> list=hs.displayAll();
		m.addAttribute("data", list);
		
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

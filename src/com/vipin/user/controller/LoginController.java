package com.vipin.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("Login called!!!");
		return "login";
	}

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		System.out.println("Logout called!!!");
		model.addAttribute("message", "You have successfully logged off from application !");
		return "home";
	}

	@RequestMapping(value = "/loginError.htm", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		System.out.println("Login Error called!!!");
		model.addAttribute("error", "true");
		return "login";

	}
}

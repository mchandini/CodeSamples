package com.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {

	@RequestMapping(value="/login")
	

	public String login() {
		return("Login");
	}
	
	/*
	 * @RequestMapping(value="/login", params="error") public String showError() {
	 * return("ErrorPage"); }
	 */
	
	
}

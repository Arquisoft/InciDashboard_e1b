package com.e1b.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {
	
	 @RequestMapping(value="/login", method = RequestMethod.GET)
	 public String login(Model model) {
	     return "login";
	 }

}

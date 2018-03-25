package com.e1b.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapsController {
	
	   @RequestMapping("/map")
	    public String map(Model model) {
	    	return "map";
	    }

}

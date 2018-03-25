package com.e1b.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	
	private static final Logger logger = Logger.getLogger(DashboardController.class);

    @RequestMapping("/")
    public String landing(Model model) {
        return "index";
    }
    
    @RequestMapping("/home")
    public String home(Model model) {
        return "home";
    }

}

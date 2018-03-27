package com.e1b.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e1b.services.InciService;

@Controller
public class MapsController {
	
	@Autowired
	private InciService inciService;
	
	   @RequestMapping("/map")
	    public String map(Model model) {
		    model.addAttribute("incidencias", inciService.findAll());
	    	return "map";
	    }

}

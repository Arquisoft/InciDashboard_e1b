package com.e1b.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.e1b.entities.Incidencia;
import com.e1b.services.InciService;


@Controller
public class InciController {

	@Autowired
	public InciService inciService;
	
	@RequestMapping(value = "/incidencias/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Incidencia> incidences = new ArrayList<Incidencia>();
		incidences = inciService.findAll();
		model.addAttribute("inciList", incidences);
		return "/incidencias/list";
	}
	
}

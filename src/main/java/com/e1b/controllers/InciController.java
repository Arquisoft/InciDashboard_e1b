package com.e1b.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public String list(Model model, Pageable pageable) {
		Page<Incidencia> incidences = inciService.findAll(pageable);
		model.addAttribute("inciList", incidences);
		return "/incidencias/list";
	}
	
}

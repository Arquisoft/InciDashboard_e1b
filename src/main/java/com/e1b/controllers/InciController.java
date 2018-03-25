package com.e1b.controllers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.e1b.entities.Incidencia;
import com.e1b.services.InciService;
import com.e1b.services.OperariosService;


@Controller
public class InciController {

	@Autowired
	InciService inciService;

//	@Autowired
//	OperariosService opService;
	
	@RequestMapping(value = "/incidencias/list", method = RequestMethod.GET)
	public String list(Model model, Pageable pageable) {
		Page<Incidencia> incidences = inciService.findAll(pageable);
		model.addAttribute("inciList", incidences);
		return "/incidencias/list";
	}
	
//	@RequestMapping(value = "/incidencias/list", method = RequestMethod.GET)
//	public String list(Model model, Principal principal, Pageable pageable) {
//		Page<Incidencia> incidences = inciService.getIncidenciasByUser(opService.getUser(principal.getName()), pageable);
//		model.addAttribute("inciList", incidences);
//		return "/incidencias/list";
//	}
	
}

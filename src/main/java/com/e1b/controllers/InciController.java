package com.e1b.controllers;

import java.security.Principal;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.e1b.entities.Incidencia;
import com.e1b.entities.Operario;
import com.e1b.services.InciService;
import com.e1b.services.OperariosService;

@Controller
public class InciController {

	@Autowired
	InciService inciService;

	@Autowired
	OperariosService opService;

	@RequestMapping(value = "/incidencias/list", method = RequestMethod.GET)
	public String list(Model model, Principal principal, Pageable pageable) {
		String username = principal.getName();
		Operario o = opService.findByUsername(username);
		Page<Incidencia> incidencias = new PageImpl<Incidencia>(new LinkedList<Incidencia>());
		incidencias = inciService.getIncidenciasByUser(o, pageable);
		model.addAttribute("inciList", incidencias.getContent());
		model.addAttribute("page", incidencias);
		return "/incidencias/list";
	}
	
	

}

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

import com.e1b.entities.Incidence;
import com.e1b.services.InciService;

@Controller
public class NotificationController 
{

	@Autowired
	InciService inciService;

	@RequestMapping(value = "/notifications/list", method = RequestMethod.GET)
	public String list(Model model, Principal principal, Pageable pageable) {
		Page<Incidence> notis = new PageImpl<Incidence>(new LinkedList<Incidence>());
		notis = inciService.findByNotification("si",pageable);
		model.addAttribute("notiList", notis.getContent());
		model.addAttribute("page", notis);
		return "/notifications/list";
	}

}

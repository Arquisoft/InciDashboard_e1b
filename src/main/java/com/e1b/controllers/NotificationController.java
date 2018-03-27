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

import com.e1b.entities.Notification;
import com.e1b.services.NotificationService;

@Controller
public class NotificationController 
{

	@Autowired
	NotificationService notiServi;

	@RequestMapping(value = "/notifications/list", method = RequestMethod.GET)
	public String list(Model model, Principal principal, Pageable pageable) {
		Page<Notification> notis = new PageImpl<Notification>(new LinkedList<Notification>());
		notis = notiServi.findAll(pageable);
		model.addAttribute("notiList", notis.getContent());
		model.addAttribute("page", notis);
		return "/notifications/list";
	}

}

package com.e1b.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.e1b.entities.Incidence;
import com.e1b.entities.Operario;
import com.e1b.kafka.KafkaProducer;
import com.e1b.services.InciService;
import com.e1b.services.OperariosService;

@Controller
public class InciController {

	@Autowired
	InciService inciService;

	@Autowired
	OperariosService opService;
	
	@Autowired
	KafkaProducer kafkaProducer;

	private final List<SseEmitter> emitters = new ArrayList<>();

	@RequestMapping(value = "/incidencias/list", method = RequestMethod.GET)
	public String list(Model model, Principal principal, Pageable pageable) {
		Page<Incidence> incidencias = new PageImpl<Incidence>(new LinkedList<Incidence>());
		incidencias = inciService.findAll(pageable);
		model.addAttribute("inciList", incidencias.getContent());
		model.addAttribute("page", incidencias);
		return "/incidencias/list";
	}

	@RequestMapping(value = "/incidencias/estado/{id}")
	public String getStatus(Model model, @PathVariable ObjectId id) {
		model.addAttribute("id", id);
		List<String> lista = new ArrayList<String>();
		lista.add("ABIERTA");
		lista.add("CERRADA");
		lista.add("ANULADA");
		lista.add("EN_PROCESO");
		model.addAttribute("statesList", lista);
		return "incidencias/estado";
	}

	@RequestMapping(value = "/incidencias/estado/{id}", method = RequestMethod.POST)
	public String setStatus(@PathVariable ObjectId id, String status) {
		Incidence inci = inciService.findById(id);
		inci.setState(status);
		kafkaProducer.send("incidencesModify",inci.toString());
		inciService.addIncidencia(inci);
		return "redirect:/incidencias/list";
	}

	@RequestMapping(value = "/incidencias/statistics")
	public String getStatus(Model model,Principal principal) {
		long[] data= new long[4] ;
		List<Incidence> incidencias = inciService.findAll();
		data[0]=incidencias.stream().filter(i->i.getState().equals("Abierta")).count();
		data[1]=incidencias.stream().filter(i->i.getState().equals("CERRADA")).count();
		data[2]=incidencias.stream().filter(i->i.getState().equals("ANULADA")).count();
		data[3]=incidencias.stream().filter(i->i.getState().equals("EN_PROCESO")).count();
		model.addAttribute("estadisticas",data);
		return "/incidencias/statistics";
	}

	public List<SseEmitter> getEmitters() {
		return emitters;
	}

	public SseEmitter getLatestEmitter() {
		return (emitters.isEmpty()) ? null : emitters.get(emitters.size() - 1);
	}

	@GetMapping("/kafka-messages")
	public SseEmitter getKafkaMessages() {
		SseEmitter emitter = new SseEmitter();
		emitters.add(emitter);
		emitter.onCompletion(new Runnable() {
			@Override
			public void run() {
				emitters.remove(emitter);
			}
		});
		emitter.onTimeout(new Runnable() {
			@Override
			public void run() {
				emitters.remove(emitter);
			}
		});
		return emitter;
	}

}

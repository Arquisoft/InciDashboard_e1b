package com.e1b.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

import com.e1b.entities.Incidencia;
import com.e1b.entities.Operario;
import com.e1b.entities.utils.Status;
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
		String username = principal.getName();
		Operario o = opService.findByUsername(username);
		Page<Incidencia> incidencias = new PageImpl<Incidencia>(new LinkedList<Incidencia>());
		incidencias = inciService.getIncidenciasByUser(o, pageable);
		model.addAttribute("inciList", incidencias.getContent());
		model.addAttribute("page", incidencias);
		return "/incidencias/list";
	}

	@RequestMapping(value = "/incidencias/estado/{id}")
	public String setStatus(Model model, @PathVariable Long id) {
		model.addAttribute("id", id);
		List<String> lista = new ArrayList<String>();
		lista.add(Status.ABIERTA.name());
		lista.add(Status.CERRADA.name());
		lista.add(Status.ANULADA.name());
		lista.add(Status.EN_PROCESO.name());
		model.addAttribute("statesList", lista);
		return "incidencias/estado";
	}

	@RequestMapping(value = "/incidencias/estado/{id}", method = RequestMethod.POST)
	public String getStatus(@PathVariable Long id, Status status) {
		Incidencia inci = inciService.findById(id);
		inci.setStatus(status);
		kafkaProducer.send("actualizationTopic", "Nombre: "+inci.getName()+" Description: "+inci.getDescription()+" New State: "+inci.getStatus());

		inciService.addIncidencia(inci);
		return "redirect:/incidencias/list";
	}

	@RequestMapping(value = "/incidencias/statistics")
	public String getStatus(Model model,Principal principal) {
		long[] data= new long[4] ;
		Operario o = opService.findByUsername(principal.getName());
		List<Incidencia> incidencias = inciService.getIncidenciasByUser(o, null).getContent();
		data[0]=incidencias.stream().filter(i->i.getStatus().equals(Status.ABIERTA)).count();
		data[1]=incidencias.stream().filter(i->i.getStatus().equals(Status.CERRADA)).count();
		data[2]=incidencias.stream().filter(i->i.getStatus().equals(Status.ANULADA)).count();
		data[3]=incidencias.stream().filter(i->i.getStatus().equals(Status.EN_PROCESO)).count();
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

package com.e1b.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e1b.entities.Incidence;
import com.e1b.services.InciService;

@Controller
public class MapsController {

	@Autowired
	private InciService inciService;

	@RequestMapping("/map")
	public String map(Model model) {
		double[] data = new double[2];
		List<double[]> coordenadas = new ArrayList<double[]>();
		List<Incidence> incidencias =  inciService.findAll();
		for (Incidence i :incidencias) {
			double lat = Double.parseDouble(i.getLocation().split(",")[0]);
			double lng = Double.parseDouble(i.getLocation().split(",")[1]);
			data[0] = lat;
			data[1] = lng;
			coordenadas.add(data);
			data = new double[2];
		}
		
		model.addAttribute("incidencias", coordenadas);
		return "map";
	}

}

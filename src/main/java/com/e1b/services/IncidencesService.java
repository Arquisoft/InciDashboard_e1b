package com.e1b.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.e1b.entities.Incidencia;

@Service
public class IncidencesService {

	public List<Incidencia> getIncidences() {
		ArrayList<Incidencia> a=new ArrayList<Incidencia>();
		a.add(new Incidencia("Incidencia",43.3,-5.1));
		return a;
	}

}

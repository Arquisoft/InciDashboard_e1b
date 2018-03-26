package com.e1b.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e1b.entities.Incidencia;
import com.e1b.entities.Operario;

@Service
public class InsertSampleDataService {
	
	@Autowired
	private OperariosService operariosService;
	
	@PostConstruct
	public void init() {
		Operario o1=new Operario("o1","123456");
//		Incidencia i = new Incidencia("Fuga gas","")
		operariosService.addOperario(o1);
	}

}

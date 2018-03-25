package com.e1b.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.e1b.entities.Incidencia;
import com.e1b.entities.Operario;
import com.e1b.repositories.InciRepository;



@Service
public class InciService {

	@Autowired
	private InciRepository inciRepository;
	
	public Page<Incidencia> findAll(Pageable pageable){
		return inciRepository.findAll(pageable);
	}
	
	public Page<Incidencia> getIncidenciasByUser(Operario op, Pageable pageable){
		return inciRepository.findInciByUser(op, pageable);
	}
	
}

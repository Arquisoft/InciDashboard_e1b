package com.e1b.services;


import java.util.ArrayList;
import java.util.List;

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
	
	public Incidencia findById(Long id){
		return inciRepository.findOne(id);
	} 
	
	public Page<Incidencia> getIncidenciasByUser(Operario op, Pageable pageable){
		return inciRepository.findInciByOperario(op, pageable);
	}
	public void addIncidencia(Incidencia i) {
		inciRepository.save(i);
	}

	public List<Incidencia> findAll() {
		List<Incidencia> list=new ArrayList<>();
		inciRepository.findAll().forEach(list::add);
		return list;
	}
	
}

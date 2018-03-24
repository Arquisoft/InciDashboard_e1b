package com.e1b.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e1b.entities.Incidencia;
import com.e1b.repositories.InciRepository;



@Service
public class InciService {

	@Autowired
	public InciRepository inciRepository;
	
	public List<Incidencia> findAll(){
		return inciRepository.findAll();
	}
	
}

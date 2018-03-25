package com.e1b.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e1b.entities.Operario;
import com.e1b.repositories.OperariosRepository;

@Service
public class OperariosService {
	
	@Autowired
	private OperariosRepository operariosRepository;

	public void addOperario(Operario o1) {
		operariosRepository.addOperario(o1);
	}
	
	public void findByUsername(String username) {
		operariosRepository.findByUsername(username);
	}
	
    public Operario getUser(String id) {
    	return operariosRepository.findOne(id);
    }


}

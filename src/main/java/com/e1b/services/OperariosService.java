package com.e1b.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e1b.entities.Operario;
import com.e1b.repositories.OperariosRepository;

@Service
public class OperariosService {
	
	@Autowired
	private OperariosRepository operariosRepository;

	public void addOperario(Operario o1) {
		operariosRepository.save(o1);
	}
	
	public Operario findByUsername(String username) {
		return operariosRepository.findByUsername(username);
	}
	
    public Operario getUser(ObjectId id) {
    	return operariosRepository.findOne(id);
    }


}

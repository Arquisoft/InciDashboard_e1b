package com.e1b.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.e1b.entities.Operario;

@Repository
public class OperariosRepository {
	
	private Map<String,Operario> bd = new HashMap<String,Operario>();

	public Operario findByUsername(String username) {
		return bd.get(username);
	}

	public void addOperario(Operario o1) {
		bd.put(o1.getUsername(), o1);
	}

}

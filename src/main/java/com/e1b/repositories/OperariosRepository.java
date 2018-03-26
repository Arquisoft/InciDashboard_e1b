package com.e1b.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.e1b.entities.Incidencia;
import com.e1b.entities.Operario;

public interface OperariosRepository extends CrudRepository<Operario, Long> {

	// private Map<String,Operario> bd = new HashMap<String,Operario>();

	public Operario findByUsername(String username);
	
	public Operario findOne(Long id);

}

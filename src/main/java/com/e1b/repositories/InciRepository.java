package com.e1b.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.e1b.entities.Incidencia;

@Repository
public interface InciRepository extends CrudRepository<Incidencia, Long> {

	List<Incidencia> findAll();
	
}

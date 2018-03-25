package com.e1b.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.e1b.entities.Incidencia;
import com.e1b.entities.Operario;

public interface InciRepository extends CrudRepository<Incidencia, Long> {

	Page<Incidencia> findAll(Pageable pageable);
	
	Page<Incidencia> findInciByOperario(Operario op, Pageable pageable);
	
}

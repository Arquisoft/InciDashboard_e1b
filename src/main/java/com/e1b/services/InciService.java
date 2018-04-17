package com.e1b.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.e1b.entities.Incidence;
import com.e1b.repositories.InciRepository;

@Service
public class InciService {

	@Autowired
	private InciRepository inciRepository;

	public Page<Incidence> findAll(Pageable pageable) {
		return inciRepository.findAll(pageable);
	}

	public Incidence findById(ObjectId id) {
		return inciRepository.findOne(id);
	}

	public Page<Incidence> getIncidenciasByUser(String op, Pageable pageable) {
		return inciRepository.findInciByOperario(op, pageable);
	}

	public List<Incidence> getIncidenciasByUser(String op) {
		return inciRepository.findInciByOperario(op);
	}

	public void addIncidencia(Incidence i) {
		inciRepository.save(i);
	}

	public List<Incidence> findAll() {
		List<Incidence> list = new ArrayList<>();
		inciRepository.findAll().forEach(list::add);
		return list;
	}

	public Page<Incidence> findByNotification(String notification,Pageable pageable) {
		// TODO Auto-generated method stub
		return inciRepository.findByNotification(notification,pageable);
	}

}

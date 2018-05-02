package com.e1b.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.e1b.entities.Incidence;

public interface InciRepository extends MongoRepository<Incidence, ObjectId> {

	Page<Incidence> findAll(Pageable pageable);
	
	@Query("{'assignedTo':?0}")
	List<Incidence> findInciByOperario(String assignedTo);

	Page<Incidence> findByNotification(String notification, Pageable pageable);

}

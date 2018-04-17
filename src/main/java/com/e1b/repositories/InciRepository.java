package com.e1b.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.e1b.entities.Incidence;

public interface InciRepository extends MongoRepository<Incidence, ObjectId> {

	Page<Incidence> findAll(Pageable pageable);

	Page<Incidence> findInciByOperario(String username, Pageable pageable);

	List<Incidence> findInciByOperario(String username);

	Page<Incidence> findByNotification(String notification, Pageable pageable);

}

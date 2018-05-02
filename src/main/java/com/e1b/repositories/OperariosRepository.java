package com.e1b.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.e1b.entities.Operario;

public interface OperariosRepository extends MongoRepository<Operario, ObjectId> {

	public Operario findByUsername(String username);
	
	public Operario findOne(ObjectId id);

}

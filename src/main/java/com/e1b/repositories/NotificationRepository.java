package com.e1b.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.e1b.entities.Incidencia;
import com.e1b.entities.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long> {
	

	Page<Notification> findAll(Pageable pageable);
	
	Page<Notification> findNotiByIncidence(Incidencia inci, Pageable pageable);

}

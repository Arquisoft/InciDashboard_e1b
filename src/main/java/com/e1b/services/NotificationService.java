package com.e1b.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.e1b.entities.Incidencia;
import com.e1b.entities.Notification;
import com.e1b.repositories.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository notiRepo;
	
	public Page<Notification> findAll(Pageable pageable){
		return notiRepo.findAll(pageable);
	} 
	
	public Notification findById(Long id){
		return notiRepo.findOne(id);
	} 
	
	public Page<Notification> getNotificationByIncidence(Incidencia inci, Pageable pageable){
		return notiRepo.findNotiByIncidence(inci, pageable);
	}
	public void addNotification(Notification n) {
		notiRepo.save(n);
	}
	

}

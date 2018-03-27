package com.e1b.services;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e1b.entities.Incidencia;
import com.e1b.entities.Notification;
import com.e1b.entities.Operario;
import com.e1b.entities.utils.Status;

@Service
public class InsertSampleDataService {
	
	@Autowired
	private OperariosService operariosService;
	@Autowired
	private InciService inciService;
	@Autowired
	private NotificationService notiService;
	
	@PostConstruct
	public void init() {
		Operario o1=new Operario("o1","123456");
		Operario o2=new Operario("o2","123456");
		Date fecha = new Date();
		Incidencia i = new Incidencia("Fuga gas","blbablal",fecha,Status.ABIERTA,o1,12,34);
		Incidencia i1 = new Incidencia("Incendio","blbablal",fecha,Status.ABIERTA,o1,12,34);
		Incidencia i2 = new Incidencia("Daño","blbablal",fecha,Status.ABIERTA,o1,12,34);
		Notification n = new Notification(i1);
		operariosService.addOperario(o1);
		operariosService.addOperario(o2);
		inciService.addIncidencia(i);
		inciService.addIncidencia(i1);
		inciService.addIncidencia(i2);
		notiService.addNotification(n);
	}

}

package com.e1b.kafka;

import java.io.IOException;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.e1b.controllers.InciController;
import com.e1b.controllers.NotificationController;
import com.e1b.creators.InciCreator;
import com.e1b.entities.Incidencia;
import com.e1b.entities.Notification;
import com.e1b.services.InciService;
import com.e1b.services.NotificationService;

/**
 * Created by mario
 */
@ManagedBean
public class MessageListener {

	private static final Logger logger = Logger.getLogger(MessageListener.class);
	
	@Autowired
	private InciController inciController;
	
	@Autowired
	private InciService inciService;
	
	@Autowired
	private NotificationController notiController;
	
	@Autowired
	private NotificationService notiService;

	@KafkaListener(topics = "incidences")
	public void listen(String data) {
		logger.info("New incidencia received: \"" + data + "\"");
		SseEmitter latestEm = inciController.getLatestEmitter();

		try {
			Incidencia inci;
			
			try {
				inci = InciCreator.parseIncidence(data);			
				inciService.addIncidencia(inci);
				if(inci.getHasNoti())
				{
					notiService.addNotification(new Notification(inci));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			latestEm.send(data);
		} catch (IOException e) {
			latestEm.completeWithError(e);
		}

	}
}

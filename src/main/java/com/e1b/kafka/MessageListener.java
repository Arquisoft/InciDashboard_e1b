package com.e1b.kafka;

import java.io.IOException;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.e1b.controllers.InciController;
import com.e1b.entities.Incidence;
import com.e1b.services.InciService;
import com.google.gson.Gson;

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

	@KafkaListener(topics = "incidences")
	public void listen(String data) {
		logger.info("New incidencia received: \"" + data + "\"");
		SseEmitter latestEm = inciController.getLatestEmitter();

		try {
			Incidence inci;
			inci = new Gson().fromJson(data, Incidence.class);
			try {
				inciService.addIncidencia(inci);
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

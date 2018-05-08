package com.e1b.kafkaManager;

import java.io.IOException;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.e1b.controllers.InciController;
import com.e1b.entities.Incidence;
import com.e1b.services.OperariosService;
import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.google.gson.Gson;

/**
 * Created by mario
 */
@ManagedBean
public class MessageListener {

	private static final Logger logger = Logger.getLogger(MessageListener.class);

	@Autowired
	private OperariosService operariosService;
	@Autowired
	private InciController inciController;

	@KafkaListener(topics = "hj0am83d-incidences")
	public void lisener(String data) {

		for (SseEmitter emitter : inciController.getEmitters()) {
		    try {
			emitter.send(data, MediaType.APPLICATION_JSON);
			System.out.println(data);
		    } catch (IOException e) {
			emitter.complete();
		    }
		}
		

	}
}

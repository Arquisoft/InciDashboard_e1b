package com.e1b.kafka;

import java.io.IOException;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.e1b.controllers.InciController;
import com.e1b.entities.Incidence;
import com.e1b.services.OperariosService;
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

	@KafkaListener(topics = "incidences")
	public void listen(String data) {
		logger.info("New incidencia received: \"" + data + "\"");
		SseEmitter latestEm = inciController.getLatestEmitter();

		try {
			Incidence inci;
			inci = new Gson().fromJson(data, Incidence.class);
			String username = inci.getAssignedTo();
			inci.setOperario(operariosService.findByUsername(username));
			if (inci.getOperario() == null) {
				throw new IllegalStateException(
						"nombre del operario incorrectamente recibido, no existe en la base de datos");
			} else {
				System.out.println(inci);
				latestEm.send(inci.toString());
			}

		} catch (IOException e) {
			latestEm.completeWithError(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

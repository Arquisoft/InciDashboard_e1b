package com.e1b.controllers;

import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e1b.entities.Incidencia;
import com.e1b.entities.Operario;
import com.e1b.entities.utils.Status;

import mock.KafkaProducer;

@Controller
public class ProducerController {
	
	
//	@RequestMapping(value="/enviarIncidencia")
//	public String enviarIncidencia() {
//		Operario o = new Operario("o3","123456");
//		Incidencia iprueba =new Incidencia("Daño","blbablal",new Date(),Status.ABIERTA,o,12,34);
//		kafkaproducer.send("exampleTopic",new JSONObject(iprueba).toString());
//		return "redirect:";
//		
//	}
}

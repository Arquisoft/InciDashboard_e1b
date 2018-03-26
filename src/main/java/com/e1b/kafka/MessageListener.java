package com.e1b.kafka;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.e1b.entities.Incidencia;
import com.e1b.services.InciService;

/**
 * Created by mario
 */
@ManagedBean
public class MessageListener {

    private static final Logger logger = Logger.getLogger(MessageListener.class);
    
    @Autowired
    InciService inciService;

    @KafkaListener(topics = "exampleTopic")
    public void listen(Incidencia i) {   	
        logger.info("New incidencia received: \"" + i.toString() + "\"");
        inciService.addIncidencia(i);
       
    }



}

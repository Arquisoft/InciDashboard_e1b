package com.e1b.kafka;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import javax.annotation.ManagedBean;

/**
 * Created by mario
 */
@ManagedBean
public class MessageListener {

    private static final Logger logger = Logger.getLogger(MessageListener.class);

    @KafkaListener(topics = "exampleTopic")
    public void listen(String data) {
    	//actualizar la vista aqui
        logger.info("New message received: \"" + data + "\"");
    }



}

package com.xdlx.service.java.mq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class ArtemisProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(Destination destination,final String message){
        jmsMessagingTemplate.convertAndSend(destination,message );
    }

    @JmsListener(destination = "out.queue")
    public void consumerMessage(String text) {
        System.out.println(" receive from out.queue : " + text);
    }
}

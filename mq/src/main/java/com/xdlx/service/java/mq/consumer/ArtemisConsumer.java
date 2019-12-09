package com.xdlx.service.java.mq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ArtemisConsumer {

    @JmsListener(destination = "vector.queue")
    @SendTo("out.queue")
    public String receiveQueue(String text){
        System.out.println("Artemis Consumer " + text);
        return "consume msg " + text;
    }
}

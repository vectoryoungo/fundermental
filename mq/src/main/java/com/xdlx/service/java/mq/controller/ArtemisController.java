package com.xdlx.service.java.mq.controller;

import com.xdlx.service.java.mq.producer.ArtemisProducer;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

@RestController
public class ArtemisController {

    @Autowired
    private ArtemisProducer artemisProducer;

    @ResponseBody
    @RequestMapping(value = "/artemis",method = RequestMethod.GET)
    public Object artemisPerformance() {
        Destination destination = new ActiveMQQueue("vector.queue");
        artemisProducer.send(destination,"Test Artemis Message Send And Receive");
        return "success";
    }
}

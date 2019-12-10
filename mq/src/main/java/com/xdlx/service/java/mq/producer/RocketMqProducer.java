package com.xdlx.service.java.mq.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RocketMqProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public String sendMsg(String content) {
        String topic = "vector-topic";
        rocketMQTemplate.convertAndSend(topic,content);
        return "success";
    }
}

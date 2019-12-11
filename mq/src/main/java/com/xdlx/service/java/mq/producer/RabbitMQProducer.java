package com.xdlx.service.java.mq.producer;

import com.xdlx.service.java.mq.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendAmqp(String message) {
        amqpTemplate.convertAndSend(rabbitMQConfig.getQueue().getName(),message);
    }

    public void sendRabbit(String message) {
        rabbitTemplate.convertAndSend(rabbitMQConfig.getQueue().getName(),message);
    }
}

package com.xdlx.service.java.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "vectorQueue")
public class RabbitMQConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitHandler
    public void process(String content) {
        LOG.info("consume {}",content);
    }
}

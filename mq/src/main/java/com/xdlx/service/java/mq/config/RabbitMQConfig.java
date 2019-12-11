package com.xdlx.service.java.mq.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue getQueue(){
        return new Queue("vectorQueue");
    }
}

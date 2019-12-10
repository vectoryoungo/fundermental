package com.xdlx.service.java.mq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
@EnableScheduling
public class KafkaMessageProducer {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${vector.kafka.app.topic.vteam}")
    private String topic;

    //@Scheduled(cron = "00/5 * * * * ?")
    public void send() {
        String message = "Hello World---" + System.currentTimeMillis();
        LOG.info("topic="+topic+",message="+message);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.addCallback(success -> LOG.info("KafkaMessageProducer Success！"),
                fail -> LOG.error("KafkaMessageProducer Failed！"));
    }

}

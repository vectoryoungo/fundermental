package com.xdlx.service.java.mq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "vector-topic",consumerGroup = "vector-group")
public class RocketMQConsumer implements RocketMQListener<String> {

    public static final Logger LOGGER = LoggerFactory.getLogger(RocketMQConsumer.class);

    @Override
    public void onMessage(String s) {
        LOGGER.info(" consume message {} ",s);
    }
}

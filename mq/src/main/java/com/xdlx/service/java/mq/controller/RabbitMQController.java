package com.xdlx.service.java.mq.controller;

import com.xdlx.service.java.mq.dto.RabbitDTO;
import com.xdlx.service.java.mq.enums.RabbitTypeEnum;
import com.xdlx.service.java.mq.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rabbit")
public class RabbitMQController {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @RequestMapping(value = "/rabbitSend",method = RequestMethod.POST)
    public void sendMsg(RabbitDTO rabbitDTO) {

        RabbitTypeEnum rabbitTypeEnum = RabbitTypeEnum.getByValues(rabbitDTO.getType());

        switch (rabbitTypeEnum) {
            case ORDER:
                rabbitMQProducer.sendAmqp(rabbitDTO.getContent());
                break;
            case REGIST:
                rabbitMQProducer.sendRabbit(rabbitDTO.getContent());
                break;
            default:
                break;
        }
    }

}

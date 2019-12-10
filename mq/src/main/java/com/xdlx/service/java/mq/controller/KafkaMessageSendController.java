package com.xdlx.service.java.mq.controller;

import com.xdlx.service.java.mq.service.KafkaMessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaMessageSendController {

    @Autowired
    private KafkaMessageSendService kafkaMessageSendService;

    @ResponseBody
    @RequestMapping(value = "/kafka/{message}",method = RequestMethod.GET)
    public String send(@PathVariable("message") String message){
        try {
            kafkaMessageSendService.send(message);
        } catch (Exception e) {
            return "send failed.";
        }
        return message;
    }

}

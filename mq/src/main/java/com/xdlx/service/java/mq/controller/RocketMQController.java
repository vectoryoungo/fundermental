package com.xdlx.service.java.mq.controller;

import com.xdlx.service.java.mq.producer.RocketMqProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RocketMQController {

    public static final Logger LOGGER = LoggerFactory.getLogger(RocketMQController.class);

    @Autowired
    private RocketMqProducer rocketMqProducer;
    @ResponseBody
    @RequestMapping(value = "/rocket/{info}",method = RequestMethod.GET)
    public void test(@PathVariable("info") String info) throws Exception {

        String result = rocketMqProducer.sendMsg(info);
        System.out.println("result " + result);
    }

}

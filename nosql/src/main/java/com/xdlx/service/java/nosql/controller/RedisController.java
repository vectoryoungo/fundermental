package com.xdlx.service.java.nosql.controller;


import com.xdlx.service.java.nosql.dto.OrderDTO;
import com.xdlx.service.java.nosql.util.RedisUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class RedisController {

    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public boolean addOrder(OrderDTO orderDTO) {
        boolean success = RedisUtils.set("vector001",orderDTO);
        return success;
    }

    @RequestMapping(value = "/getOrder/{key}",method = RequestMethod.GET)
    public Object getOrder(@PathVariable("key")String key){
        return RedisUtils.get(key);
    }
}

package com.xdlx.service.java.nosql.controller;


import com.xdlx.service.java.nosql.annotations.AnRateLimiter;
import com.xdlx.service.java.nosql.annotations.RedisLimit;
import com.xdlx.service.java.nosql.dto.OrderDTO;
import com.xdlx.service.java.nosql.util.RedisUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/order")
public class RedisController {

    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public boolean addOrder(OrderDTO orderDTO) {
        boolean success = RedisUtils.set("vector001",orderDTO);
        return success;
    }

//    @AnRateLimiter(permitsPerSecond = 1,timeout = 500,timeunit = TimeUnit.MILLISECONDS,msg = "over heat !!!")
    @RedisLimit(key = "vectorNoSql",period = 20,count = 5)
    @RequestMapping(value = "/getOrder/{key}",method = RequestMethod.GET)
    @ResponseBody
    public Object getOrder(@PathVariable("key")String key){
        return RedisUtils.get(key);
    }
}

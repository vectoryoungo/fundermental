/*
 * module: fundermental
 * file: SpringAsyncController.java
 * date: 6/14/20 3:08 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-14 15:08
 * @desc test async when exception occured
 **/
package com.xlab.service_java_infrastructure.controller;

import com.xlab.service_java_infrastructure.spring.service.DataProcessService;
import com.xlab.service_java_infrastructure.vo.AcceptContentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAsyncController {

    @Autowired
    private DataProcessService dataProcessService;

    @RequestMapping(value = "/accept",method = RequestMethod.POST)
    public String acceptData(AcceptContentVO acceptContentVO){
        dataProcessService.process(acceptContentVO);
        System.out.println("controller Thread is "+Thread.currentThread().getId()+Thread.currentThread().getName());
        return "success";
    }
}


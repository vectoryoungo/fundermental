/*
 * module: fundermental
 * file: SpringParameterTestController.java
 * date: 5/17/20 9:35 PM
 * author: VectorJu
 */

/**
 * @create 2020-05-17 21:35
 * @desc SpringBoot是如何解析参数的
 **/
package com.sd.lx.vector.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import java.util.concurrent.*;

@Controller
public class SpringParameterTestController {



    private ExecutorService executorService = new ThreadPoolExecutor(200,300,0L,
            TimeUnit.SECONDS,new LinkedBlockingDeque<>(10000),new ThreadPoolExecutor.DiscardPolicy());

    @RequestMapping("test")
    public void testParameter(){
        DispatcherServlet dispatcherServlet;
        HandlerMapping handlerMapping;
        RequestMappingHandlerAdapter requestMappingHandlerAdapter;
        HandlerMethodArgumentResolver handlerMethodArgumentResolver;
        RequestParamMethodArgumentResolver requestParamMethodArgumentResolver;
        RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor;
        AbstractMessageConverterMethodArgumentResolver abstractMessageConverterMethodArgumentResolver;
        /**
         * 是基于链表的、线程安全的双端阻塞队列.底层采用一个双向的链表来实现
         */
        LinkedBlockingDeque linkedBlockingDeque;
        /**
         * 基于链表的先进先出的阻塞队列 通过ReentrantLock和两个Condition来实现并发安全与阻塞
         */
        LinkedBlockingQueue linkedBlockingQueue;
    }
}


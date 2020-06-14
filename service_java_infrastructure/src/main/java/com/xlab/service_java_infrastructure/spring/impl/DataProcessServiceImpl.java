/*
 * module: fundermental
 * file: DataProcessServiceImpl.java
 * date: 6/14/20 3:14 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-14 15:13
 * @desc implementation of DataProcessService
 **/
package com.xlab.service_java_infrastructure.spring.impl;

import com.xlab.service_java_infrastructure.spring.service.DataProcessService;
import com.xlab.service_java_infrastructure.vo.AcceptContentVO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class DataProcessServiceImpl implements DataProcessService {

    @Override
    @Async("vectorThreadPool")
    public void process(AcceptContentVO acceptContentVO) {
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
        System.out.println(Thread.currentThread().getId() + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getState());
        String content = acceptContentVO.getContent();
        String testSubString = content.substring(0,8);
        System.out.println(testSubString);
    }
}


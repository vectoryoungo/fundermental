/*
 * module: fundermental
 * file: ICoinUsdtServiceImpl.java
 * date: 9/19/19 6:08 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-19 18:08
 * @desc implemetation
 **/
package com.xlab.service_java_infrastructure.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ICoinUsdtServiceImpl implements ICoinUsdtService {

    private Logger log = LoggerFactory.getLogger(ICoinUsdtServiceImpl.class);

    @Scheduled(fixedRate = 1000)
    @Override
    public void jobScan1() {
        for (int i=0;i<100;i++) {
            if (i%2==0) {

            }

            if (i%3==0) {

            }
        }
//        System.out.println("jobScan1 running... " + Thread.currentThread().getName());
    }

    @Scheduled(fixedRate = 2000)
    @Async("taskExecutor")
    public void jobScan2() {
        System.out.println("jobScan2 running... start " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("jobScan2 running... end " + Thread.currentThread().getName());
    }
}


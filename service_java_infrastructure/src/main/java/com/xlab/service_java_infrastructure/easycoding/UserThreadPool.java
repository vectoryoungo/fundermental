/*
 * module: fundermental
 * file: UserThreadPool.java
 * date: 3/27/19 5:42 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-27 17:42
 * @desc UserThreadPool
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UserThreadPool {

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(2);

        UserThreadFactory userThreadFactory = new UserThreadFactory("First Compute House");
        UserThreadFactory userThreadFactory1= new UserThreadFactory("Two Compute House");

        UserRejectHandler handler = new UserRejectHandler();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,2,60, TimeUnit.SECONDS,queue,userThreadFactory,handler);
        ThreadPoolExecutor threadPoolExecutorSecond = new ThreadPoolExecutor(1,2,60,TimeUnit.SECONDS,queue,userThreadFactory1,handler);
        Runnable task = new Task();

        for (int i=0;i<200;i++) {
            threadPoolExecutor.execute(task);
            threadPoolExecutorSecond.execute(task);
        }
    }
}


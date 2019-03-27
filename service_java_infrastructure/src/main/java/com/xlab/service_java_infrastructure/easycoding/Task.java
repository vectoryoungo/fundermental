/*
 * module: fundermental
 * file: Task.java
 * date: 3/27/19 5:39 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-27 17:38
 * @desc simulate of task
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.util.concurrent.atomic.AtomicLong;

public class Task implements Runnable{

    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}


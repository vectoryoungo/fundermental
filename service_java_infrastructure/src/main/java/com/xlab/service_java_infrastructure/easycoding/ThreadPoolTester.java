/*
 * module: fundermental
 * file: ThreadPoolTester.java
 * date: 3/26/19 4:24 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-26 16:24
 * @desc ThreadPoolTester
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTester {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor;
        Executors executors;
        Executor executor;
        Executors.defaultThreadFactory();
        Executors.newWorkStealingPool();//import at JDK8
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(20);
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(20);
    }
}


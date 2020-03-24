/*
 * module: fundermental
 * file: ReentrantReadWriteLockTransientSimulator.java
 * date: 3/22/20 11:24 AM
 * author: VectorJu
 */

/**
 * @create 2020-03-22 11:24
 * @desc 测试字段firstReaderHoldCount
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.Random;

public class ReentrantReadWriteLockTransientSimulator {

    private transient int firstReaderHoldCount;


    private final int tryAcquireShared(int unused) {
        return firstReaderHoldCount++;
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        for (int i=0;i<100000;i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int interval = random.nextInt(100);
//                    System.out.println("interval "+interval);
                    int result = new ReentrantReadWriteLockTransientSimulator().tryAcquireShared(interval);
                    if (result == 1) {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println(Thread.currentThread().getId());
                        System.out.println("hit!!!");
                    }
                }
            });
            thread.start();
        }
    }
}


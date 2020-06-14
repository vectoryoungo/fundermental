/*
 * module: fundermental
 * file: TestHarness.java
 * date: 6/8/20 10:36 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-08 22:35
 * @desc 在时许测试中，使用CountDownLatch来启动和停止线程
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class TestHarness {

    public long timeTasks(int nThreads,final Runnable task) throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i=0;i<nThreads;i++){
            Thread t = new Thread(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId());
                   try {
                       startGate.await();
                       try {
                           task.run();
                       }finally {
                           endGate.countDown();
                       }
                   }catch (InterruptedException e) {

                   }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return  end - start;
    }

}


/*
 * module: fundermental
 * file: TestCoresizeAndMaxSize.java
 * date: 6/8/20 6:36 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-08 18:36
 * @desc 线程池corePoolSize和maximumPoolSize关系
 * 可以创建最大的线程数 = 队列最大长度 + maxPoolSize，
 * 优先使用队列，如果队列满了，才使用maxPoolSize
 * 进入队列的线程数量 = max(线程数-corePoolSize， 队列最大长度)
 * 直接执行的线程数量 = if(线程数量>corePoolSize and 线程数量<=队列最大长度) {
 *
 *               return 线程数量-corePoolSize
 *
 *              } else if(线程数量>队列最大长度 and 线程数量<=maxPoolSize + 队列最大长度) {
 *
 *                     return 线程数量 - 队列最大长度
 *
 *              } else if(线程数量>maxPoolSize + 队列最大长度){
 *
 *                    return 线程数量 - 队列最大长度（ 其他被抛弃或报错）
 *
 *             }
 *
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class TestCoresizeAndMaxSize {


    public static void main(String[] args) {
        SynchronousQueue synchronousQueue;
        AbstractQueuedSynchronizer abstractQueuedSynchronizer;
//        //使用只能5个有限队列，corePoolSize=2, maxPoolSize=10
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10,
//                0L, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<>(5));
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
//
//        //创建15个线程
//        for (int i = 0; i < 15; i++) {
//            final int a = i;
//            executor.submit(() -> {
//                try {
//                    Thread.sleep(500);
//                    System.out.println(a + "   --- " + executor.getQueue().size());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//        executor.shutdown();

        //使用只能5个有限队列，corePoolSize=15, maxPoolSize=15
        ThreadPoolExecutor executor = new ThreadPoolExecutor(15, 15,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5));

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());


        //创建15个线程
        for (int i = 0; i < 20; i++) {
            int size = executor.getQueue().size();
            executor.execute(new MyThread(i,size));
        }

        executor.shutdown();
    }
}


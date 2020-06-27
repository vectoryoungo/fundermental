/*
 * module: fundermental
 * file: BoundedExecutorSimulator.java
 * date: 6/21/20 4:36 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-21 16:36
 * @desc client test bounded executor
 * 当工作队列充满后，并没有预置的饱和策略来阻塞execute。
 * 但是使用Semaphore可以实现这个效果。Semaphore会限制任务注入率（injection rate）。
 * 这种方法使用一个非受限队列（没有理由同时限制队列大小和注入率），设置Semaphore的限制范围等于在池的大小上加上你希望允许的可以排队的任务数量，
 * 因为semaphore限制的是当前执行的任务数和等待执行的任务数。
 **/
package com.xlab.service_java_infrastructure.concurrent;

import com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.Element;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BoundedExecutorSimulator {

    public static void main(String[] args) {

        int cpu = Runtime.getRuntime().availableProcessors();
        Executor threadPoolExecutor = Executors.newFixedThreadPool(cpu);
        AtomicInteger atomicInteger = new AtomicInteger(10000);
        BoundedExecutor boundedExecutor = new BoundedExecutor(threadPoolExecutor,cpu);
        System.out.println("cpu Avaliable " + cpu);
        for (int i=0;i<100;i++) {
            try {
                boundedExecutor.submitTask(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("calculate is " + atomicInteger.decrementAndGet());
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        TimingThreadPool timingThreadPool = new TimingThreadPool(cpu,cpu,cpu, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());

        for (int i = 0;i<10;i++) {
            timingThreadPool.beforeExecute(new Thread(), new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" is running......");
                }
            });
            timingThreadPool.afterExecute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("after Execute " + Thread.currentThread().getName()+" is running");
                }
            },new Throwable());
            timingThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+ " start ");
                }
            });
            timingThreadPool.terminated();
        }
    }
}


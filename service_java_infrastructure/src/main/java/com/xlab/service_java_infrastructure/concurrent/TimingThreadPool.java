/*
 * module: fundermental
 * file: TimingThreadPool.java
 * date: 6/21/20 7:48 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-21 19:48
 * @desc 扩展线程池以提供日志和计时功能
 **/
package com.xlab.service_java_infrastructure.concurrent;

import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class TimingThreadPool extends ThreadPoolExecutor{

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final Logger logger = Logger.getLogger("TimingThreadPool");
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t,Runnable r) {
        super.beforeExecute(t,r);
        logger.fine(String.format("Thread %s: start %s ",t,r));
        startTime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r,Throwable t) {

        try {
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            logger.fine(String.format("Thread %s: end %s,time=%dns",t,r,taskTime));

        }finally {
            super.afterExecute(r,t);
        }
    }

    @Override
    protected void terminated() {
        try {
            logger.info(String.format("Terminated: avg time=%dns",totalTime.get()/numTasks.get()));
        }finally {
            super.terminated();
        }
    }
}


/*
 * module: fundermental
 * file: BoundedExecutor.java
 * date: 6/21/20 4:25 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-21 16:25
 * @desc 使用Semaphore来遏制任务的提交
 * 当工作队列充满后，并没有预置的饱和策略来阻塞execute。
 * 但是使用Semaphore可以实现这个效果。Semaphore会限制任务注入率（injection rate）。
 * 这种方法使用一个非受限队列（没有理由同时限制队列大小和注入率），设置Semaphore的限制范围等于在池的大小上加上你希望允许的可以排队的任务数量，
 * 因为semaphore限制的是当前执行的任务数和等待执行的任务数。
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

public class BoundedExecutor {

    private final Executor executor;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor exec,int bound) {
        this.executor = exec;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final  Runnable command) throws InterruptedException{
        semaphore.acquire();

        try {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    }finally {
                        semaphore.release();
                    }

                    System.out.println(Thread.currentThread().getId()+":"+Thread.currentThread().getName());
                }
            });
        }catch (RejectedExecutionException e) {
                semaphore.release();
        }
    }
}


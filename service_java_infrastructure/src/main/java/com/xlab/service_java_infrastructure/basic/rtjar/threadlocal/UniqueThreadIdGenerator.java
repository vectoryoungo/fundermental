/*
 * module: fundermental
 * file: UniqueThreadIdGenerator.java
 * date: 10/6/19 9:37 AM
 * author: VectorJu
 */
/**
 * Do Not Use ThreadLocal with ExecutorService
 * If we want to use an ExecutorService and submit a Runnable to it, using ThreadLocal will yield non-deterministic results
 * because we do not have a guarantee that every Runnable action for a given userId will be handled by the same thread every time it is executed.
 * Because of that, our ThreadLocal will be shared among different userIds.
 * That's why we should not use a TheadLocal together with ExecutorService.
 * It should only be used when we have full control over which thread will pick which runnable action to execute.
 */
/**
 * @create 2019-10-06 09:37
 * @desc UniqueThreadIdGenerator
 **/
package com.xlab.service_java_infrastructure.basic.rtjar.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueThreadIdGenerator {

    // 原子整型
    private static final AtomicInteger uniqueId = new AtomicInteger(0);

    // 线程局部整型变量
    private static final ThreadLocal <Integer> uniqueNum =
            new ThreadLocal < Integer > () {
                @Override protected Integer initialValue() {
                    return uniqueId.getAndIncrement();
                }
            };

    //变量值
    public static int getUniqueId() {
        return uniqueNum.get();
    }

    public static void main(String[] args) {
        UniqueThreadIdGenerator uniqueThreadId = new UniqueThreadIdGenerator();
        // 为每个线程生成一个唯一的局部标识
        TaskThread t1 = new TaskThread<UniqueThreadIdGenerator>("custom-thread-1", uniqueThreadId);
        TaskThread t2 = new TaskThread<UniqueThreadIdGenerator>("custom-thread-2", uniqueThreadId);
        TaskThread t3 = new TaskThread<UniqueThreadIdGenerator>("custom-thread-3", uniqueThreadId);
        t1.start();
        t2.start();
        t3.start();
    }
}


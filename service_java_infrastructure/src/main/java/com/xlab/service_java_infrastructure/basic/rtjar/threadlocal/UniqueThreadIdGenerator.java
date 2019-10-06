/*
 * module: fundermental
 * file: UniqueThreadIdGenerator.java
 * date: 10/6/19 9:37 AM
 * author: VectorJu
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


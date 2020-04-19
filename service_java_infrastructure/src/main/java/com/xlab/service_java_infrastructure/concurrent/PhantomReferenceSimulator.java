/*
 * module: fundermental
 * file: PhantomReferenceSimulator.java
 * date: 4/19/20 6:17 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-19 18:17
 * @desc test PhantomReference 虚引用唯一的目的就是用来管理堆外内存，
 * 如下所示意思，需要结合ReferenceQueue一起使用。当需要处理回收堆外内存时候，直接将虚引用和需要回收的对象绑定到队列中。
 * JVM会回收这块不用的内存。
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

public class PhantomReferenceSimulator {

    private static final List<Object> container = new LinkedList<>();
    private static final ReferenceQueue<Weak> phantomReferenceQueue = new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference<Weak> phantomReference = new PhantomReference<>(new Weak(),phantomReferenceQueue);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    container.add(new byte[1024*1024*100]);
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    System.out.println(phantomReference.get());
                }
            }
        },"threadOne").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Reference<? extends Weak> poll = phantomReferenceQueue.poll();
                    if (poll != null) {
                        System.out.println("虚引用被JVM回收"+poll);
                    }
                }
            }
        },"threadTwo").start();

        try {
            Thread.sleep(500);
        }catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}


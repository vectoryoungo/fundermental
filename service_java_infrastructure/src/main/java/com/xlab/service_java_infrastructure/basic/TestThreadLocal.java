/*
 * module: fundermental
 * file: TestThreadLocal.java
 * date: 5/2/19 9:45 AM
 * author: VectorJu
 */

/**
 * @create 2019-05-02 09:45
 * @desc test of thread Local
 **/
package com.xlab.service_java_infrastructure.basic;

public class TestThreadLocal {

    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final TestThreadLocal test = new TestThreadLocal();
        test.set();
        System.out.println("start " + test.getLong());
        System.out.println("start " + test.getString());

        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println("inner " + test.getLong());
                System.out.println("inner " + test.getString());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println("end " + test.getLong());
        System.out.println("end " + test.getString());
    }
}


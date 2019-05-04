/*
 * module: fundermental
 * file: ReentrantTest.java
 * date: 5/2/19 5:31 PM
 * author: VectorJu
 */

/**
 * @create 2019-05-02 17:31
 * @desc ReentrantTest
 **/
package com.xlab.service_java_infrastructure.basic;

public class ReentrantTest implements Runnable{

    public synchronized void get() {
        System.out.println(Thread.currentThread().getName());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getName());
    }

    public void run() {
        get();
    }

    public static void main(String[] args) {
        ReentrantTest rt = new ReentrantTest();
        for(;;){
            new Thread(rt).start();
        }
    }
}


/*
 * module: fundermental
 * file: SynchronizedSimulator.java
 * date: 12/24/18 5:40 PM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-24 17:40
 * @desc test of lock
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedSimulator {

    private int count = 10;

    public void testSubtract() {

        //with lock
        /*for (int i=0;i<10;i++) {
            synchronized (this) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        --count;
                        System.out.println("Thread:" + Thread.currentThread().getName() + " count:" + count);
                    }

                }).start();
            }
            //System.out.println("Thread:" + Thread.currentThread().getName() + " count:" + count);

        }*/

        //without lock
            for (int i=0;i<10;i++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        --count;
                        System.out.println("Thread:" + Thread.currentThread().getName() + " count:" + count);
                    }

                }).start();
                //System.out.println("Thread:" + Thread.currentThread().getName() + " count:" + count);
            }
    }

    public static void main(String[] args) {
        SynchronizedSimulator synchronizedSimulator = new SynchronizedSimulator();
        synchronizedSimulator.testSubtract();
    }
}


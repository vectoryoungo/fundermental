/*
 * module: fundermental
 * file: ConcurrentCalSimulation.java
 * date: 12/26/18 2:01 PM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 14:01
 * @desc test of concurrent
 * volatile 只能保证可见性不能保证原子性。不是加锁只是保证CPU缓存的可见。
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentCalSimulation {

    volatile  int sharedNumber = 0;

    void notifyMsg() {
        for(int i=0;i<10000;i++) {
            sharedNumber++;
        }
    }

    public static void main(String[] args) {
        final ConcurrentCalSimulation concurrentCalSimulation = new ConcurrentCalSimulation();
        List<Thread> threads = new ArrayList<>();

        for (int i=0;i<10;i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    concurrentCalSimulation.notifyMsg();
                }
            }));
        }

        for (Thread thread:threads) {
            thread.start();
        }

        for (Thread thread:threads) {
            try {
                thread.join();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("concurrentCalSimulation.sharedNumber " + concurrentCalSimulation.sharedNumber);
    }
}


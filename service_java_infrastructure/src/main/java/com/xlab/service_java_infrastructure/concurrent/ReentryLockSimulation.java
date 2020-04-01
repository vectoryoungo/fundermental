/*
 * module: fundermental
 * file: ReentryLockSimylation.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: ReentryLockSimulation.java
 * date: 12/26/18 10:20 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 10:20
 * @desc test of re entry lock
 * 可重入锁。同一个线程，多次调用同步代码，锁定同一个锁对象。
 * 多线程锁定同一个对象时不可重入的.
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentryLockSimulation {

    private static int totalCount = 100;
    private Lock lock = new ReentrantLock();

    public void decrease() {
        try {
//            lock.lock();
            totalCount--;

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
//            lock.unlock();
        }
    }

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                ReentryLockSimulation reentryLockSimulation = new ReentryLockSimulation();
                for (int i=0;i<10;i++) {
                    System.out.print(Thread.currentThread().getId());

                    reentryLockSimulation.decrease();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ReentryLockSimulation reentryLockSimulation = new ReentryLockSimulation();
                for (int i=0;i<10;i++) {
                    System.out.print(Thread.currentThread().getId());
                    reentryLockSimulation.decrease();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ReentryLockSimulation reentryLockSimulation = new ReentryLockSimulation();
                for (int i=0;i<10;i++) {
                    System.out.print(Thread.currentThread().getId());
                    reentryLockSimulation.decrease();
                }
            }
        }).start();


        try {
            Thread.sleep(1);
            System.out.println(ReentryLockSimulation.totalCount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


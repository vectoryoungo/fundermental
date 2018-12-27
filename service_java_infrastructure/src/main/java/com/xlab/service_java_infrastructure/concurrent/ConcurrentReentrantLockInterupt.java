/*
 * module: fundermental
 * file: ConcurrentReentrantLockInterupt.java
 * date: 12/27/18 11:17 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-27 11:17
 * @desc interrupt
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentReentrantLockInterupt {

    Lock lock = new ReentrantLock();

    void notifyMsg() {
        try {
            lock.lock();
            for (int i=0;i<10;i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(" notifyMsg() " + i);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void notifyMsgDuplicate() {
        try {
            lock.lockInterruptibly();
        }catch (InterruptedException e) {
            System.out.println("nofityMsgDuplicate is interrupted ");
        }finally {
            try {
                lock.unlock();
            }catch (Exception e) {
                System.out.println(" interrupt execute in finally ");
            }
        }
        System.out.println("notifyMsgDuplicate() is end ");
    }

    public static void main(String[] args) {
        final ConcurrentReentrantLockInterupt concurrentReentranlockSimulator = new ConcurrentReentrantLockInterupt();

        new Thread(new Runnable() {
            @Override
            public void run() {
                concurrentReentranlockSimulator.notifyMsg();
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread copy = new Thread(new Runnable() {
            @Override
            public void run() {
                concurrentReentranlockSimulator.notifyMsgDuplicate();
            }
        });

        copy.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        copy.interrupt();
    }
}


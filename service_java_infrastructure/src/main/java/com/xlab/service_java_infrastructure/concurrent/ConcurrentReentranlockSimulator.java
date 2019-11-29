/*
 * module: fundermental
 * file: ConcurrentReentranlockSimulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: ConcurrentReentranlockSimulator.java
 * date: 12/27/18 10:15 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-27 10:15
 * @desc concurrent reentrant lock simulation
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentReentranlockSimulator {

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
        lock.lock();
        System.out.println("notifyMsgDuplicate() ");
        lock.unlock();
    }

    public static void main(String[] args) {
        final ConcurrentReentranlockSimulator concurrentReentranlockSimulator = new ConcurrentReentranlockSimulator();

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

        new Thread(new Runnable() {
            @Override
            public void run() {
                concurrentReentranlockSimulator.notifyMsgDuplicate();
            }
        }).start();
    }
}


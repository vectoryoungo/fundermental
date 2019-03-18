/*
 * module: fundermental
 * file: ConcurrentReentrantlockWithTry.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

/*
 * module: fundermental
 * file: ConcurrentReentrantlockWithTry.java
 * date: 12/27/18 10:33 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-27 10:33
 * @desc test of reentrantlock with try lock
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentReentrantlockWithTry {

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
        boolean isLocked = false;

        try {
            isLocked = lock.tryLock();
            if (isLocked) {
                System.out.println("notifyMsgDuplicate is locked ");
            } else {
                System.out.println("notifyMsgDuplicate is unlock ");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (isLocked) {
                lock.unlock();
            }
        }
        System.out.println("notifyMsgDuplicate() is end ");
    }

    public static void main(String[] args) {
        final ConcurrentReentrantlockWithTry concurrentReentranlockSimulator = new ConcurrentReentrantlockWithTry();

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


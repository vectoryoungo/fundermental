/*
 * module: fundermental
 * file: ReentrantLockSimulator.java
 * date: 8/21/19 4:23 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-21 16:23
 * @desc simulate reentrant lock
 **/
package com.xlab.service_java_infrastructure.basic.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSimulator {

    private Lock lock = new ReentrantLock(false);
    //Lock lock=new ReentrantLock(true);//公平锁
    //Lock lock=new ReentrantLock(false);//非公平锁
    private Condition condition=lock.newCondition();//创建Condition

    public void testMethod() {
        try {
            lock.lock();//lock 加锁
            //1：wait 方法等待：
            System.out.println("开始wait");
            condition.await();
            //通过创建Condition 对象来使线程wait，必须先执行lock.lock 方法获得锁
            //:2：signal 方法唤醒
            condition.signal();//condition 对象的signal 方法可以唤醒wait 线程
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName()+ (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(" exception ....");
        } finally {
            lock.unlock();
            System.out.println(" unlock ");
        }
    }


}


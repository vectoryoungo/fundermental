/*
 * module: fundermental
 * file: CharOutputReentrantLockSimulator.java
 * date: 3/25/20 12:40 PM
 * author: VectorJu
 */

/**
 * @create 2020-03-25 12:40
 * @desc use reentrantlock output char
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CharOutputReentrantLockSimulator {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        char[] first = "123456789".toCharArray();
        char[] second = "ABCDEFGHI".toCharArray();
        Condition thread1Condition = lock.newCondition();
        Condition thread2Condition = lock.newCondition();

        new Thread(()->{
                lock.lock();

                try {
                    for (char c:first){
                        System.out.print(c);
                        thread2Condition.signal();
                        thread1Condition.await();
                    }
                    thread2Condition.signal();
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

        },"thread1").start();

        new Thread(()->{

                lock.lock();
                try {
                    for (char c:second) {
                        System.out.print(c);
                        thread1Condition.signal();
                        thread2Condition.await();
                    }
                    thread1Condition.signal();
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

        },"thread2").start();
    }
}


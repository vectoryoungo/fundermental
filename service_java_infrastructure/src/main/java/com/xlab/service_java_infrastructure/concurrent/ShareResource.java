/*
 * module: fundermental
 * file: ShareResource.java
 * date: 10/12/19 3:41 PM
 * author: VectorJu
 */

/**
 * @create 2019-10-12 15:41
 * @desc combine with concurrentOperateWithLockAndCondition
 **/
package com.xlab.service_java_infrastructure.concurrent;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * c1: print five loop
 * c2: print ten loop
 * c3: print fifteen loop
 * c4: print twenty loop
 */
public class ShareResource {

    private int number = 5;
    private Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    Condition c4 = lock.newCondition();

    public void printFiveLoop() {

        try{
            lock.lock();
            while (number !=5) {
                c1.await();
            }
            for (int i=0;i<5;i++) {
                System.out.println("printFiveLoop " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
            }
            number = 10;
            c2.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printTenLoop() {
        try{
            lock.lock();
            while (number!=10) {
                c2.await();
            }

            for (int i=0;i<10;i++) {
                System.out.println("printTenLoop " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
            }

            number = 15;
            c3.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printFifteenLoop() {

        try {
            lock.lock();
            while (number!=15) {
                c3.await();
            }
            for (int i=0;i<15;i++) {
                System.out.println("printFifteenLoop " + Thread.currentThread().getName() + " "+Thread.currentThread().getId());
            }

            number = 20;
            c4.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printTwentyLoop() {
        try {
            lock.lock();
            while (number !=20) {
                c4.await();
            }

            for (int i=0;i<20;i++) {
                System.out.println("printTwentyLoop " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
            }

            number = 5;
            c1.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

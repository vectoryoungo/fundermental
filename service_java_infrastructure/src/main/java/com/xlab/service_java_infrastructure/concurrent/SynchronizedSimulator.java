/*
 * module: fundermental
 * file: SynchronizedSimulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

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


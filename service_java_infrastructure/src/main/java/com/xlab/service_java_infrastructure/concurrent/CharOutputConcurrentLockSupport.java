/*
 * module: fundermental
 * file: CharOutputConcurrentLockSupport.java
 * date: 4/18/20 10:06 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-18 22:05
 * @desc 多线程交替输出1A2B3C4D5E6F7G
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.locks.LockSupport;

public class CharOutputConcurrentLockSupport {

    static Thread threadFirst = null,threadSecond = null;

    public static void main(String[] args) {
        char[] sequenceFirst = "1234567".toCharArray();
        char[] sequenceSecond= "ABCDEFG".toCharArray();
        threadFirst = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c:sequenceFirst){
                    System.out.println(c);
                    LockSupport.unpark(threadSecond);
                    LockSupport.park(threadFirst);
                }
            }
        },"threadFirst");
        threadFirst.start();

        threadSecond = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : sequenceSecond) {

                    System.out.println(c);
                    if (c == 'G') {
                        System.out.println(Thread.currentThread().getId());
                        System.out.println(Thread.currentThread().getName());
                        Thread.currentThread().interrupt();
                    }
                    LockSupport.unpark(threadFirst);
                    LockSupport.park(threadSecond);

                }
            }

        },"threadSecond");
        threadSecond.start();
    }
}


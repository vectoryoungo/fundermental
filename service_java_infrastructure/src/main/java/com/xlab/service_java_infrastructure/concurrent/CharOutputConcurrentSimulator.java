/*
 * module: fundermental
 * file: CharOutputConcurrentSimulator.java
 * date: 3/25/20 10:31 AM
 * author: VectorJu
 */

/**
 * @create 2020-03-25 10:31
 * @desc test two thread output char 对一个对象调用wait()方法，不是让这个对象去wait，而是让持有这个对象的锁的线程去wait。
 **/
package com.xlab.service_java_infrastructure.concurrent;

public class CharOutputConcurrentSimulator {

    private static final Object object = new Object();

    public static void main(String[] args) {
        char[] first = "123456789".toCharArray();
        char[] second = "ABCDEFGHI".toCharArray();

        new Thread(()->{
            synchronized (object){
                for (char c:first){
                    System.out.print(c);
                    try {
                        object.notify();
                        object.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        },"thread1").start();

        new Thread(()->{
            synchronized (object){
                for (char c:second) {
                    System.out.print(c);
                    try {
                        object.notify();
                        object.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        },"thread2").start();
    }
}


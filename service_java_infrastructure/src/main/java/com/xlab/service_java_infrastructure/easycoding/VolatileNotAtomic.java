/*
 * module: fundermental
 * file: VolatileNotAtomic.java
 * date: 3/26/19 3:17 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-26 15:17
 * @desc VolatileNotAtomic
 **/
package com.xlab.service_java_infrastructure.easycoding;

public class VolatileNotAtomic {


    private static volatile long count = 0L;
    private static final int NUMBER = 10000;

    public static void main(String[] args) {
        Thread subtractThread = new SubtractThread();
        subtractThread.start();

        for (int i=0;i<NUMBER;i++){
            synchronized (subtractThread) {
                count++;
            }
        }

        //等待减法线程结束
        while (subtractThread.isAlive()) {}

        System.out.println("count 最后的值为: " + count);
    }

    private static class SubtractThread extends Thread{

        @Override
        public void run(){
            for (int i=0;i<NUMBER;i++){
                synchronized (this) {
                    count--;
                }
            }
        }
    }
}


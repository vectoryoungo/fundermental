/*
 * module: fundermental
 * file: ReentrantFairLock.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: ReentrantFairLock.java
 * date: 12/29/18 4:42 PM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-29 16:41
 * @desc reentrantFairlock
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantFairLock extends Thread{

    private static ReentrantLock reentrantLock = new ReentrantLock(true);
    private static int totalGoods = 100;
//    private Object lock = new Object();

    @Override
    public void run() {
        try {
            System.out.println("thread-" + Thread.currentThread().getId());
            reentrantLock.lock();
            System.out.println(totalGoods);
            //sold out
            if (totalGoods == 0) return;
            totalGoods--;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
//        for (int i=0;i<1000000;i++) {
//
////            synchronized (lock){
//            System.out.println(totalGoods);
//                //sold out
//                if (totalGoods == 0) return;
//                try {
//                    totalGoods--;
////                    System.out.println(Thread.currentThread().getName() + " reentrant lock fair ");
//                }catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                reentrantLock.unlock();
//                }
////            }
//        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i=0;i<1000;i++) {
            ReentrantFairLock reentrantFairLock = new ReentrantFairLock();
            reentrantFairLock.run();
            if (reentrantFairLock.totalGoods ==0) {
                break;
            }
            System.out.println(" after promoting total is " + reentrantFairLock.totalGoods);
        }
        System.out.println(" it takes " +(System.currentTimeMillis()-start));
    }

}


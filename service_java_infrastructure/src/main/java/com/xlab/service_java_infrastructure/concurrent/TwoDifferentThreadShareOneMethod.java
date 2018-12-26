/*
 * module: fundermental
 * file: TwoDifferentThreadShareOneMethod.java
 * date: 12/26/18 10:56 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 10:56
 * @desc test of two thread shared one method
 * 同步方法中发生异常自动释放锁不影响其他线程的执行
 * 同步业务逻辑中发生异常的处理要商讨。
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.TimeUnit;

public class TwoDifferentThreadShareOneMethod {

    int sharedNumber = 0;

    synchronized void notifyMsg() {
        System.out.println( " begin out loop " + Thread.currentThread().getName() + " - start ");

        while (true) {
            sharedNumber++;
            System.out.println(" inner loop " + Thread.currentThread().getName() + " ---- " + sharedNumber);

            try {
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (sharedNumber == 5) {
                System.out.println(Thread.currentThread().getName() + "  sharedNumber " + sharedNumber);
                sharedNumber = 1/0;
            }
        }
    }

    public static void main(String[] args) {
        final TwoDifferentThreadShareOneMethod twoDifferentThreadShareOneMethod = new TwoDifferentThreadShareOneMethod();

        new Thread(new Runnable() {
            @Override
            public void run() {
                twoDifferentThreadShareOneMethod.notifyMsg();
            }
        },"thread one ").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                twoDifferentThreadShareOneMethod.notifyMsg();
            }
        }," thread two ").start();

    }

    /**
     * 打印结果
     * 如果是main方法如此写：
     * final TwoDifferentThreadShareOneMethod twoDifferentThreadShareOneMethod = new TwoDifferentThreadShareOneMethod();
     * 结果如下：
     * begin out loop thread one  - start
     * inner loop thread one  ---- 1
     * inner loop thread one  ---- 2
     * inner loop thread one  ---- 3
     * inner loop thread one  ---- 4
     * inner loop thread one  ---- 5
     * begin out loop  thread two  - start
     * inner loop  thread two  ---- 6
     * Exception in thread "thread one " java.lang.ArithmeticException: / by zero
     * at com.xlab.service_java_infrastructure.concurrent.TwoDifferentThreadShareOneMethod.notifyMsg(TwoDifferentThreadShareOneMethod.java:35)
     * at com.xlab.service_java_infrastructure.concurrent.TwoDifferentThreadShareOneMethod$1.run(TwoDifferentThreadShareOneMethod.java:46)
     * at java.lang.Thread.run(Thread.java:748)
     * inner loop  thread two  ---- 7
     * inner loop  thread two  ---- 8
     * inner loop  thread two  ---- 9
     * inner loop  thread two  ---- 10
     */

    /**
     * 如果main方法中如此写：
     *  TwoDifferentThreadShareOneMethod twoDifferentThreadShareOneMethod = new TwoDifferentThreadShareOneMethod();
     *  结果就是：
     *
     * begin out loop thread one  - start
     * inner loop thread one  ---- 1
     * inner loop thread one  ---- 2
     * inner loop thread one  ---- 3
     * inner loop thread one  ---- 4
     * inner loop thread one  ---- 5
     * Exception in thread "thread one " java.lang.ArithmeticException: / by zero
     * thread one   sharedNumber 5
     * begin out loop  thread two  - start
     * at com.xlab.service_java_infrastructure.concurrent.TwoDifferentThreadShareOneMethod.notifyMsg(TwoDifferentThreadShareOneMethod.java:38)
     * inner loop  thread two  ---- 6
     * at com.xlab.service_java_infrastructure.concurrent.TwoDifferentThreadShareOneMethod$1.run(TwoDifferentThreadShareOneMethod.java:49)
     * at java.lang.Thread.run(Thread.java:748)
     * inner loop  thread two  ---- 7
     * inner loop  thread two  ---- 8
     * inner loop  thread two  ---- 9
     * inner loop  thread two  ---- 10
     */
}


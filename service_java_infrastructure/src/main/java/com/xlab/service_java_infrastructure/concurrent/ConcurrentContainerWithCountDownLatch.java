/*
 * module: fundermental
 * file: ConcurrentContainerWithCountDownLatch.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: ConcurrentContainerWithCountDownLatch.java
 * date: 12/27/18 10:01 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-27 10:01
 * @desc count down latch simulator
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ConcurrentContainerWithCountDownLatch {

    public static void main(String[] args) {

        final ConcurrentContainerOrigin concurrentContainerOrigin = new ConcurrentContainerOrigin();
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (concurrentContainerOrigin.size() != 5) {
                    try {
                        countDownLatch.await();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(" size is 5 ");
            }

        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (countDownLatch){
                    for (int i=0;i<10;i++) {
                        System.out.println(" add start " + i);
                        concurrentContainerOrigin.add(new Object());
                        if (concurrentContainerOrigin.size() == 5) {
                            countDownLatch.countDown();
                        }
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}


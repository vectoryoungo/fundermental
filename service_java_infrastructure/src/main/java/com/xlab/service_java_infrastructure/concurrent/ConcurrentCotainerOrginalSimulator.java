/*
 * module: fundermental
 * file: ConcurrentCotainerOrginalSimulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: ConcurrentCotainerOrginalSimulator.java
 * date: 12/26/18 6:34 PM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 18:34
 * @desc orginal simulator
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.TimeUnit;

public class ConcurrentCotainerOrginalSimulator {

    public static void main(String[] args) {

        final ConcurrentContainerOrigin concurrentContainerOrigin = new ConcurrentContainerOrigin();
        Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    if (concurrentContainerOrigin.size() != 5) {
                        try {
                            lock.wait();
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(" size is 5 ");
                    lock.notifyAll();
                }
            }

        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i=0;i<10;i++) {
                        System.out.println(" add start " + i);
                        concurrentContainerOrigin.add(new Object());
                        if (concurrentContainerOrigin.size() == 5) {
                            lock.notifyAll();
                            try {
                                lock.wait();
                            }catch (InterruptedException e) {
                                e.printStackTrace();
                            }
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


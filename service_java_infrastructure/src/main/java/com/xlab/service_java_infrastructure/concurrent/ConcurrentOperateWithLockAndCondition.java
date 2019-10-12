/*
 * module: fundermental
 * file: ConcurrentOperateWithLockAndCondition.java
 * date: 10/12/19 3:40 PM
 * author: VectorJu
 */

/**
 * @create 2019-10-12 15:40
 * @desc simulate operate lock and condition
 **/
package com.xlab.service_java_infrastructure.concurrent;

public class ConcurrentOperateWithLockAndCondition {


    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource();

        Thread fiveLoop = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {
                    shareResource.printFiveLoop();
                }
            }
        });

        Thread tenLoop = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {
                    shareResource.printTenLoop();
                }
            }
        });

        Thread fifteenLoop = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {
                    shareResource.printFifteenLoop();
                }
            }
        });

        Thread twentyLoop = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {
                    shareResource.printTwentyLoop();
                }
            }
        });

        fiveLoop.start();
        tenLoop.start();
        fifteenLoop.start();
        twentyLoop.start();
    }
}


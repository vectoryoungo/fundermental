/*
 * module: fundermental
 * file: ConcurrentLabWithStop.java
 * date: 18-8-25 下午11:06
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-08-25 23:06
 * @desc current test with stop
 **/
package com.xlab.service_java_infrastructure.effective8;

import java.util.concurrent.TimeUnit;

//properly synchronized cooperative thread termination
public class ConcurrentLabWithStop {

    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException{
        Thread backgroundThread = new Thread(()->{
            int i=0;
            while (!stopRequested()){
                i++;
            }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }

}


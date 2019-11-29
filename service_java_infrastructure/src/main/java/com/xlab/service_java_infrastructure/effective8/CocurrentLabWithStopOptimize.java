/*
 * module: fundermental
 * file: CocurrentLabWithStopOptimize.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: CocurrentLabWithStopOptimize.java
 * date: 18-8-25 下午11:31
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-08-25 23:31
 * @desc optimize
 **/
package com.xlab.service_java_infrastructure.effective8;

public class CocurrentLabWithStopOptimize {

    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException{
        Thread backgroudThread = new Thread(()->{
            int i=0;
            while (!stopRequested){
                i++;
            }
        });

        backgroudThread.start();
        stopRequested = true;
    }
}


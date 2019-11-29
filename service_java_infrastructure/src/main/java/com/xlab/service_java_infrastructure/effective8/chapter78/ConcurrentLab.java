/*
 * module: fundermental
 * file: ConcurrentLab.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: ConcurrentLab.java
 * date: 18-8-25 下午8:47
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-08-25 20:47
 * @desc 测试并发停止另一个线程
 **/
package com.xlab.service_java_infrastructure.effective8.chapter78;

import java.util.concurrent.TimeUnit;

public class ConcurrentLab {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException{
        Thread backgroundThread = new Thread(()->{
            int i=0;
            while (!stopRequested) {
                i++;
            }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}


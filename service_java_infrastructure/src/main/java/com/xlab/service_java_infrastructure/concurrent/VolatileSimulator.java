/*
 * module: fundermental
 * file: VolatileSimulator.java
 * date: 12/26/18 11:43 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 11:43
 * @desc test of volatile
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.TimeUnit;

public class VolatileSimulator {

    /**
     * 如果此处不加volatile关键字则一直是死循环.volatile
     */
    volatile boolean flag = true;

    void notifyMsg() {
        System.out.println(" start notifyMsg() ");
        while (flag){}
        System.out.println(" end notifyMsg() ");
    }

    public static void main(String[] args) {
        final VolatileSimulator volatileSimulator = new VolatileSimulator();
        new Thread(new Runnable() {
            @Override
            public void run() {
                volatileSimulator.notifyMsg();
            }
        }, " thread one ").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        volatileSimulator.flag = false;
    }

}


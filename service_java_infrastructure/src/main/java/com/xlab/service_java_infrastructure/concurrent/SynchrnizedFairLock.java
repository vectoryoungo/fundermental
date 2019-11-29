/*
 * module: fundermental
 * file: SynchrnizedFairLock.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/**
 * @author juhongtao
 * @create 2018-12-29 16:40
 * @desc synchronized fair
 **/
package com.xlab.service_java_infrastructure.concurrent;

public class SynchrnizedFairLock extends Thread{


    @Override
    public void run() {
        for (int i=0;i<5;i++){
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " get lock in synchronized ");
            }
        }
    }
}


/*
 * module: fundermental
 * file: FairLockSimulation.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: FairLockSimulation.java
 * date: 12/29/18 4:44 PM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-29 16:44
 * @desc fair lock simulation
 **/
package com.xlab.service_java_infrastructure.concurrent;

public class FairLockSimulation {

    public static void main(String[] args) {
        ReentrantFairLock reentrantFairLock = new ReentrantFairLock();
        SynchrnizedFairLock synchrnizedFairLock = new SynchrnizedFairLock();
        Thread thread = new Thread(synchrnizedFairLock);
        thread.start();
        Thread thread1 = new Thread(synchrnizedFairLock);
        thread1.start();
    }
}


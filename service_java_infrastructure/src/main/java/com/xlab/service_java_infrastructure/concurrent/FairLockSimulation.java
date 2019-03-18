/*
 * module: fundermental
 * file: FairLockSimulation.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
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


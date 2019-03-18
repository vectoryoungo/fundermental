/*
 * module: fundermental
 * file: ReentrantFairLock.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

/*
 * module: fundermental
 * file: ReentrantFairLock.java
 * date: 12/29/18 4:42 PM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-29 16:41
 * @desc reentrantFairlock
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantFairLock extends Thread{

    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public void run() {
        for (int i=0;i<5;i++) {
            reentrantLock.lock();

            try {

                System.out.println(Thread.currentThread().getName() + " reentrant lock fair ");
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    }
}


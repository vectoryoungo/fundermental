/*
 * module: fundermental
 * file: ReentryLockSimylation.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

/*
 * module: fundermental
 * file: ReentryLockSimylation.java
 * date: 12/26/18 10:20 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 10:20
 * @desc test of re entry lock
 * 可重入锁。同一个线程，多次调用同步代码，锁定同一个锁对象。
 * 多线程锁定同一个对象时不可重入的.
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.TimeUnit;

public class ReentryLockSimylation {

    synchronized void show() {
        System.out.println(" start show() ");
        try {

            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        showDuplicate();
        System.out.println(" end show() ");
    }

    synchronized  void showDuplicate() {
        System.out.println(" start showDuplicate() ");
        try{

            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" end showDuplicate() ");
    }

    public static void main(String[] args) {
        ReentryLockSimylation reentryLockSimylation = new ReentryLockSimylation();
        reentryLockSimylation.show();
    }
}


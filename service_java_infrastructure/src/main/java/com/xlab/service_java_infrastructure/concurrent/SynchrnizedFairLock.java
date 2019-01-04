/*
 * module: fundermental
 * file: SynchrnizedFairLock.java
 * date: 12/29/18 4:40 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
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


/*
 * module: fundermental
 * file: ConcurrentContainerSimulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

/*
 * module: fundermental
 * file: ConcurrentContainerSimulator.java
 * date: 12/26/18 6:08 PM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 18:08
 * @desc test of concurrent container simulation
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.TimeUnit;

public class ConcurrentContainerSimulator {

    public static void main(String[] args) {
        final ConcurrentContainer concurrentContainer = new ConcurrentContainer();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {
                    System.out.println("start add " + i);
                    concurrentContainer.add(new Object());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (concurrentContainer.size() == 5) {
                        System.out.println("size is 5 ");
                        break;
                    }
                }
            }
        }).start();
    }
}


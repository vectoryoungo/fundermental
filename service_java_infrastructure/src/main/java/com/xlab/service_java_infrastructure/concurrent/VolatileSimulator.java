/*
 * module: fundermental
 * file: VolatileSimulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

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


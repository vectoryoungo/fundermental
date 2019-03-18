/*
 * module: fundermental
 * file: CocurrentLabWithStopOptimize.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

/*
 * module: fundermental
 * file: CocurrentLabWithStopOptimize.java
 * date: 18-8-25 下午11:31
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-08-25 23:31
 * @desc optimize
 **/
package com.xlab.service_java_infrastructure.effective8;

public class CocurrentLabWithStopOptimize {

    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException{
        Thread backgroudThread = new Thread(()->{
            int i=0;
            while (!stopRequested){
                i++;
            }
        });

        backgroudThread.start();
        stopRequested = true;
    }
}


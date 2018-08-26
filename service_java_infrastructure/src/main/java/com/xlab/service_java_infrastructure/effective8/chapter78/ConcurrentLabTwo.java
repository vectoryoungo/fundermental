/*
 * module: fundermental
 * file: CocurrentLabTwo.java
 * date: 18-8-25 下午11:36
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-08-25 23:35
 * @desc with no stop
 **/
package com.xlab.service_java_infrastructure.effective8.chapter78;

public class ConcurrentLabTwo {

    private static volatile int nextSerialNumber =0;

    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }

    public static void main(String[] args) {

    }
}


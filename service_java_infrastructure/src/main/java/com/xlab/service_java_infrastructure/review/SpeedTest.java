/*
 * module: fundermental
 * file: SpeedTest.java
 * date: 3/16/19 11:23 AM
 * author: VectorJu
 */

/**
 * @create 2019-03-16 11:23
 * @desc speed of mac
 **/
package com.xlab.service_java_infrastructure.review;

public class SpeedTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (long i=0;i<10000000000L;i++){
            sum = sum + i *(i+1);
        }

        System.out.println(" result sum is " + sum);
        System.out.println(" it takes " + (System.currentTimeMillis() - start)/1000);
    }
}


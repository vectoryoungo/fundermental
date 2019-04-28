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

import java.sql.Timestamp;
import java.util.Date;

public class SpeedTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0;
        /*for (long i=0;i<10000000000L;i++){
            sum = sum + i *(i+1);
        }*/

        System.out.println(" result sum is " + sum);
        System.out.println(" it takes " + (System.currentTimeMillis() - start)/1000);

        //1556415831245
        //1556415831245

        //nano 8324083432160
        //time 1556416670160
        //timestamp 1556416670160
        System.out.println("time is " + new Date().getTime());
        System.out.println("system current time millis " + System.currentTimeMillis());
        Timestamp d = new Timestamp(System.currentTimeMillis());
        System.out.println("timestamp is "  + d);
        System.out.println("timestamp time is " + d.getTime());
        System.out.println("nanos is " + d.getNanos());
        System.out.println(" nano time is " + System.nanoTime());
    }
}


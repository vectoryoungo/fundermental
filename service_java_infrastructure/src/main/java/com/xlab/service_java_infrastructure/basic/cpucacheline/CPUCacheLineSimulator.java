/*
 * module: fundermental
 * file: CPUCacheLineSimulator.java
 * date: 7/17/19 4:03 PM
 * author: VectorJu
 */

/**
 * @create 2019-07-17 16:03
 * @desc simulate cpu cacheline test
 * this illustrate how cache line work fast or not
 * horizontalLoop takes 427ms
 * landscapeLoop takes 1597ms
 * loopCompare takes 970 ms
 * loopCompareCompare takes 975ms
 * and loopCompare compare with loopCompareCompare as the same
 * The reason why the loops take the same amount of time has to do with memory.
 * my mac is 2.2 GHz Intel Core i7 4core 8 hyperThread
 * my mac memory is 16 GB 1600 MHz DDR3
 **/
package com.xlab.service_java_infrastructure.basic.cpucacheline;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CPUCacheLineSimulator {


    private static void horizontalLoop(int[][] array) {
        // 横向遍历
        for(int i = 0; i < 64 * 1024; i ++)
            for(int j = 0; j < 1024; j ++)
                array[i][j] ++;
    }

    private static void landscapeLoop(int[][] array) {
        // 纵向遍历
        for(int i = 0; i < 1024; i ++)
            for(int j = 0; j < 64 * 1024; j ++)
                array[j][i] ++;
    }

    private static void loopCompare(int[] arr) {
        // Loop 1
        for (int i = 0; i < arr.length; i++) arr[i] *= 3;
    }

    private static void loopComareCompare(int[] arr) {
        // Loop 2
        for (int i = 0; i < arr.length; i += 16) arr[i] *= 3;
    }

    private static void loopWithK(int[] arr,int K) {
        for (int i = 0; i < arr.length; i += K) arr[i] *= 3;
    }

    public static void main(String[] args) {

        long start = System.nanoTime();
       /* int[][] array = new int[64 * 1024][1024];
        if (args[0].equalsIgnoreCase("horizon")) {
            horizontalLoop(array);
        }else if (args[1].equalsIgnoreCase("landscape")) {
            landscapeLoop(array);
        }*/

        int[] arr = new int[64 * 1024 * 1024];
        /*Random random = new Random(47);
        for (int i=0;i<64 * 1024 * 1024;i++) {
            arr[i] = random.nextInt();
        }*/
        //loopCompare(arr);loopWithK
        //loopComareCompare(arr);
        loopWithK(arr,1024);

        long estimatedTime = System.nanoTime() - start;
        System.out.println(" it takes " + TimeUnit.NANOSECONDS.toMillis(estimatedTime));

    }
}


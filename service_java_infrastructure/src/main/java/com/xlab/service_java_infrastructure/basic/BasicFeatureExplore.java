/*
 * module: fundermental
 * file: BasicFeatureExplore.java
 * date: 4/29/19 10:35 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-29 10:35
 * @desc basic feature of java
 **/
package com.xlab.service_java_infrastructure.basic;

import java.util.HashMap;

public class BasicFeatureExplore {

    public static void main(String[] args) {

        HashMap hashMap  = new HashMap();

        int number = 1 << 4;
        int numberTwo = 1 << 3;
        int numberThree = 1 << 2;
        int numberFour = 1 << 1;
        int max = 1 <<30;
        int numberRight = 1 >>> 16;
        int numberRightTwo = 1 >>> 8;
        int numberRightThree = 12 >>> 16;
        System.out.println("number 1<<4 " + number);
        System.out.println("numberTwo 1<<3 " + numberTwo);
        System.out.println("numherThree 1<<2 " + numberThree);
        System.out.println("numberFour 1<<1 " + numberFour);
        System.out.println(" max is " + max);

        hashMap.put("key","fuck");
        hashMap.get("key");
        System.out.println(hashMap.get("key"));
        System.out.println("numberRight " + numberRight);
        System.out.println("numberRightTwo " + numberRightTwo);
        System.out.println("numberRightThree " + numberRightThree);
        System.out.println("+++++++++++++++++++++++++");
        process(10);
        int numbersN = 4;
        int numnberNN = 4;
        System.out.println(numbersN | numnberNN);

    }

    private static void process(int cap) {
        int n = cap - 1;
        System.out.println("before first is " + n);
        n = n | n >>> 1;
        System.out.println(" n = n | n >>> 1 " +n);
        /*n |= n >>> 1;
        System.out.println(" first >>>1 is " + n);
        n |= n >>> 2;
        System.out.println(" second >>>2 is " +n);
        n |= n >>> 4;
        System.out.println(" third >>>4 is " + n);
        n |= n >>> 8;
        System.out.println(" fourth >>>8 is " + n);
        n |= n >>> 16;
        System.out.println(" fifth >>> 16 is " + n);*/
    }
}


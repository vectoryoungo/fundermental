/*
 * module: fundermental
 * file: ConcurrentHashMapECSimulator.java
 * date: 3/22/19 8:29 AM
 * author: VectorJu
 */

/**
 * @create 2019-03-22 08:28
 * @desc easycoding concurrent hashmap
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.Math;
import java.util.concurrent.atomic.AtomicInteger;

import sun.misc.Unsafe
        ;

public class ConcurrentHashMapECSimulator {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap;
        double number = 8;
        double divided = 2;
        double result = Math.pow(8,2);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        ArrayList arrayList = new ArrayList(16);
        //atomicInteger.compareAndSet();
        System.out.println(" result is " + result);
    }
}


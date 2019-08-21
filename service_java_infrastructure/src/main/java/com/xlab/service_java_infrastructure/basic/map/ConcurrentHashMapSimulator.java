/*
 * module: fundermental
 * file: ConcurrentHashMapSimulator.java
 * date: 8/16/19 3:14 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-16 15:14
 * @desc
 **/
package com.xlab.service_java_infrastructure.basic.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentHashMapSimulator {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> hashMap = new ConcurrentHashMap<>(16);
        hashMap.putIfAbsent("1LsyyW1qRHDbz7LU3Wz3VyqV5QgdET4hrN","1LsyyW1qRHDbz7LU3Wz3VyqV5QgdET4hrN");

        if (hashMap.containsKey("1LsyyW1qRHDbz7LU3Wz3VyqV5QgdET4hrN")) {
            System.out.println("testXXXXXX");
        }

        Executors executors;
        Executor executor;
        ReentrantLock reentrantLock;
    }
}


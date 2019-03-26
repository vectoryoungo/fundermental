/*
 * module: fundermental
 * file: ResourceConsumeTest.java
 * date: 3/23/19 3:24 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-23 15:24
 * @desc test of copy on write resouce consume
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ResourceConsumeTest {

    public static void main(String[] args) {
        //List<Long> copy = new CopyOnWriteArrayList<Long>();
        List<Long> copy = new ArrayList<>();
        long start = System.nanoTime();
        for (int i=0;i<20*10000;i++) {
            copy.add(System.nanoTime());
        }

        System.out.println(" it takes " + (System.nanoTime()-start)/1000);
    }
}


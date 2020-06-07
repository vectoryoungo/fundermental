/*
 * module: fundermental
 * file: SimulatorClient.java
 * date: 6/7/20 6:40 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-07 18:40
 * @desc 测试并发客户端
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.List;
import java.util.Random;

public class SimulatorClient {

    public static void main(String[] args) {
        ListHelper listHelper = new ListHelper();
        for (int i=0;i<100000;i++){
            Thread thread = new Thread(new Runnable() {
                Random random = new Random(47);
                @Override
                public void run() {
                    int result = random.nextInt(5);
//                    System.out.println("random is " + result);
                    System.out.println(listHelper.putIfAbsent(result));
                }
            },"test thread");
            thread.start();
//            System.out.println(thread.getId()+ thread.getName());
        }

    }
}


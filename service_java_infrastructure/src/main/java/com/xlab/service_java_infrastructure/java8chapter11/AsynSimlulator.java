/*
 * module: fundermental
 * file: AsynSimlulator.java
 * date: 18-6-30 下午3:02
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-30 15:02
 * @desc asyn
 **/
package com.xlab.service_java_infrastructure.java8chapter11;

import java.util.concurrent.Future;

public class AsynSimlulator {

    public static void main(String[] args) {
        Shop shop = new Shop("BestBuy");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("pork");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + "msecs");
        // 执行更多任务，比如查询其他商店
        doSomethingElse();
        // 在计算商品价格的同时
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    private static void doSomethingElse() {
        long sum = 0;
        for (int i=0;i<100000;i++){
            if (i%4==0) {
                sum = sum+i;
            }
        }
    }
}


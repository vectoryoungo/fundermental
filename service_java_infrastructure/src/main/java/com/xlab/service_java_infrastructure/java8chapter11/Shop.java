/*
 * module: fundermental
 * file: Shop.java
 * date: 18-6-30 下午2:48
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-30 14:48
 * @desc shop demo
 **/
package com.xlab.service_java_infrastructure.java8chapter11;

import org.springframework.expression.spel.ast.FunctionReference;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPriceStr(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];

        //String.format("%s:%.2f%s",name,price,code);
        return name + ":" + price + ":" + code;
    }

    private double calculatePrice(String product) {
            delay();
            return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    //将同步方法转换为异步方法
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(()->{
            double price = calculatePrice(product);
            future.complete(price);
        }).start();

        return future;
    }

    //一行语句重写getPriceAsync方法
    public Future<Double> getPriceAsyncPromote(String product) {
        return CompletableFuture.supplyAsync(()->calculatePrice(product));
    }

    public String getName() {
        return name;
    }
}


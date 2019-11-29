/*
 * module: fundermental
 * file: AsynSimlulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

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

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class AsynSimlulator {


    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("Shit"),
            new Shop("Sex"),
            new Shop("FuckHard"),
            new Shop("whore"),
            new Shop("Gay"));

    private final Executor executor =
            Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                    new ThreadFactory() {
                        public Thread newThread(Runnable r) {
                            Thread t = new Thread(r);
                            t.setDaemon(true);
                            return t;
                        }
                    });

    public static void main(String[] args) {

       /* Shop shop = new Shop("BestBuy");
        System.out.println(shop.getPriceStr("BestBuy"));*/
        /*long start = System.nanoTime();
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
        */
        /*long start = System.nanoTime();
        System.out.println(findPricesWithCompletableFuturePromote("BuyItAll"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
*/
        System.out.println(Runtime.getRuntime().availableProcessors());


    }

    private static void doSomethingElse() {
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            if (i % 4 == 0) {
                sum = sum + i;
            }
        }
    }

    /*public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    public static List<String> findPriceWithParalletStream(String product) {
        return shops.parallelStream().map(shop -> String.format("%s price is %.2f",shop.getName(),shop.getPrice(product))).collect(toList());
    }


    //使用CompletableFuture实现findPrices方法
    public static List<String> findPriceWithCompletableFuture(String product) {
        Executor executor =
                Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                        new ThreadFactory() {
                            public Thread newThread(Runnable r) {
                                Thread t = new Thread(r);
                                t.setDaemon(true);
                                return t;
                            }
                        });
        List<CompletableFuture<String>> priceFutures = shops.stream().map(shop -> CompletableFuture.supplyAsync(()->shop.getName()+" price is "+shop.getPrice(product),executor)).collect(toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(toList());
    }

    //以最简单的方式实现使用Discount服务的findPrices方法
    public static List<String> findPricesWithDiscount(String product) {
        return shops.stream()
                .map(shop -> shop.getPriceStr(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(toList());
    }
    //使用CompletableFuture实现findPrices方法
    public static List<String> findPricesWithCompletableFuturePromote(String product){
        Executor executor =
                Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                        new ThreadFactory() {
                            public Thread newThread(Runnable r) {
                                Thread t = new Thread(r);
                                t.setDaemon(true);
                                return t;
                            }
                        });
        List<CompletableFuture<String>> priceFutures = shops.stream().
                map(shop -> CompletableFuture.supplyAsync(()->shop.getPriceStr(product),executor))
                .map(future->future.thenApply(Quote::parse))
                .map(future->future.thenCompose(quote -> CompletableFuture.supplyAsync((()->Discount.applyDiscount(quote)),executor)))
                .collect(toList());

        return priceFutures.stream().map(CompletableFuture::join).collect(toList());
    }*/

    //refactor findPrices method and return a stream with Future
    // this is error on my mac jdk1.8.0_162
    /*public Stream<CompletedFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceStr(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future-> future.thenCompose(quote -> CompletableFuture.supplyAsync(()->Discount.applyDiscount(quote),executor)));
                //.map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));
    }*/

}


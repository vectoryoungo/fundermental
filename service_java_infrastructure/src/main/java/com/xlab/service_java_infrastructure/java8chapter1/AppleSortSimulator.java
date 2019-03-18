/*
 * module: fundermental
 * file: AppleSortSimulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-17 15:02
 * @desc sort apples
 **/
package com.xlab.service_java_infrastructure.java8chapter1;

import sun.jvm.hotspot.debugger.ThreadAccess;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class AppleSortSimulator {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155,"brown"),
                new Apple(80,"grey"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });


        //traditional thread in java
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello this is traditional thread run....");
            }
        });

        //thread.start();

        //lambda thread in java8
        Thread lambdaThread = new Thread(()->System.out.println("hello this is lambda thread run..."));

        //lambdaThread.start();
        //() -> {return "Mario";}
        Runnable r1 = () -> System.out.println("Hello World 1");
        Runnable r2 = new Runnable(){
            public void run(){
                System.out.println("Hello World 2");
            }
        };
        process(r1);
        process(r2);
        process(()->System.out.println("Hello World 3"));
    }

    public static void process(Runnable r){
        r.run();
    }
}


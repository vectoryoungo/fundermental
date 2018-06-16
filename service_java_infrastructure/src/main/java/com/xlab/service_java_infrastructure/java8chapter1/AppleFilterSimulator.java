/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-16 18:08
 * @desc simulation of apple filter in java8
 **/
package com.xlab.service_java_infrastructure.java8chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilterSimulator {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        System.out.println(filterApples(inventory,Apple::isGreenApple));
        System.out.println(filterApples(inventory,Apple::isHeavyApple));

    }

    /**
     * @Author: vector.ju
     * @Description: before java8 using filter demo
     * @date 2018/6/16
     * @param inventory
     * @return List<Apple>
     *
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * @Author: vector.ju
     * @Description: filer apple which weight is more than 50g
     * @date 2018/6/16
     * @param  inventory
     * @return List<Apple> f
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    static List<Apple> filterApples(List<Apple> inventory,
                                    Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}


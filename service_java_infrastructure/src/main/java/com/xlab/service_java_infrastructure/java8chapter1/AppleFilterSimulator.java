/*
 * module: fundermental
 * file: AppleFilterSimulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

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

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppleFilterSimulator {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155,"brown"),
                new Apple(80,"grey"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        //System.out.println(filterApples(inventory,Apple::isGreenApple));
        //System.out.println(filterApples(inventory,Apple::isHeavyApple));
        //System.out.println(filterApples(inventory,(Apple a) -> "green".equals(a.getColor())));
        //System.out.println(filterApples(inventory,(Apple a) -> a.getWeight() > 150));
        //System.out.println(filterApples(inventory,(Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor())));

        //顺序处理
        List<Apple> heavyAppples = inventory.stream().filter((Apple a)->a.getWeight()>150).collect(Collectors.toList());
        System.out.println(heavyAppples.get(0).toString());

        List<Apple> heavyAppless = inventory.parallelStream().filter((Apple a)->a.getWeight()>150).collect(Collectors.toList());
        System.out.println(heavyAppless.get(0).toString());

        List<Map<String,Integer>> light = new ArrayList<>();
        List<Map<String,Integer>> weight = new ArrayList<>();



        inventory.parallelStream().forEach(apple -> {
            if (apple.getWeight() == 80){

                Map<String,Integer> lightApples = new HashMap<>();
                lightApples.put(apple.getColor(),apple.getWeight());
                light.add(lightApples);
            }else if (apple.getWeight() == 155){
                Map<String,Integer> weightApples = new HashMap<>();
                weightApples.put(apple.getColor(),apple.getWeight());
                weight.add(weightApples);
            }
        });


        System.out.println(" light size " + light.size());
        System.out.println(" weight size " + weight.size());

        /*for (Map<String,Integer> lightMap:light){

           for (Map.Entry<String,Integer> entry:lightMap.entrySet()){
               System.out.println(" light key=" + entry.getKey() + " light value=" + entry.getValue());
            }
        }

        for (Map<String,Integer> weightMap:weight) {
            for (Map.Entry<String,Integer> entry:weightMap.entrySet()) {
                System.out.println(" weight key=" + entry.getKey() + " weight value =" + entry.getValue());
            }
        }

        Map<Integer,List<Apple>> map = inventory.parallelStream().collect(Collectors.groupingBy(Apple::getWeight));
        for (Map.Entry<Integer,List<Apple>> entry:map.entrySet()) {
            System.out.println("group by key = " +entry.getKey() + " value = " + entry.getValue().size());
        }*/

        List<Apple> redApplesList = filter(inventory,(Apple apple)->"red".equals(apple.getColor()));
        System.out.println(redApplesList.get(0).toString());
        Predicate<Apple> applePredicat = (Apple a)->a.getColor().equals("red");
        Predicate<Apple> redAndHeavyApple = applePredicat.and(a -> a.getWeight() > 100);
        List<Apple> apples = filterApples(inventory,redAndHeavyApple);
        for (Apple apple:apples) {
            System.out.println(" apple is " + apple);
        }
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

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }
}


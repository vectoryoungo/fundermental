/*
 * module: fundermental
 * file: NonCovarianGenerics.java
 * date: 4/9/19 4:07 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 16:07
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonCovarianGenerics {
    //List<Fruit> fruitList = new ArrayList<Apple>();
    //blew here is show how to use extends in generic
    public static void main(String[] args) {
        /*List<? extends Fruit> fruits = new ArrayList<Apple>();
        for (int i=0;i<5;i++){
            Apple apple = new Apple();
            if (i%2==0) {
                apple.setColor("red");
            }else {
                apple.setColor("green");
            }
            //fruits.add(apple);// this is illegal
        }*/

        List<? extends Fruit> fruits = Arrays.asList(new Apple());
        Apple apple = (Apple) fruits.get(0);
        System.out.println(apple);
        System.out.println(fruits.contains(new Apple()));
        System.out.println(fruits.indexOf(new Apple()));
    }
}


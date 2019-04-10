/*
 * module: fundermental
 * file: GenericReading.java
 * date: 4/10/19 8:37 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 08:36
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericReading {

    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static void f1() {
        Apple apple = readExact(apples);
        Fruit fruit = readExact(fruits);
        fruit = readExact(apples);
        System.out.println("f1() is ok ");
    }

    static class Reader<T> {
        T readExact(List<T> list){
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<Fruit>();
        Fruit f = fruitReader.readExact(fruits);
        System.out.println("f2() is ok ");
        //Fruit fC = fruitReader.readExact(apples); this is illegal
        //readExact(List<Fruit>)
    }

    static class ConvarianReader<T> {
        T readConvariant(List<? extends T> list) {
         return list.get(0);
        }
    }

    static void f3() {
        ConvarianReader<Fruit> fruitReader = new ConvarianReader<>();
        Fruit f = fruitReader.readConvariant(fruits);
        Fruit a = fruitReader.readConvariant(apples);
        System.out.println("f3() is ok ");
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }


}


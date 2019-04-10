/*
 * module: fundermental
 * file: GenericWriting.java
 * date: 4/10/19 8:19 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 08:19
 * @desc test of border generic
 * my mac configuration is Intel coreI7 Quad-core
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {

    static<T> void writeExact(List<T> list,T item) {
        list.add(item);
    }

    static  List<Apple> apples = new ArrayList<>();
    static  List<Fruit> fruits = new ArrayList<>();

    static void f1() {
        writeExact(apples,new Apple());
        writeExact(fruits,new Apple());// according to the thinking in java fourth edition this will lead Incompatible type but in java8 this is ok
        System.out.println(" f1() check ok ");
    }

    static<T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples,new Apple());
        writeWithWildcard(fruits,new Apple());
        System.out.println("f2() is ok ");
    }

    public static void main(String[] args) {
        f1();
    }
}


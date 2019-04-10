/*
 * module: fundermental
 * file: Hold.java
 * date: 4/9/19 5:09 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 17:09
 * @desc test of extend generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class Holder<T> {

    private T value;
    public Holder(T value) {
        this.value = value;
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<Apple>(new Apple());

        Apple apple = appleHolder.get();

        appleHolder.set(apple);
        Holder<? extends Fruit> fruitHolder = appleHolder;
        Fruit fruit = fruitHolder.get();
        System.out.println("fruit is " + fruit);
        apple = (Apple) fruitHolder.get();
        System.out.println("apple ? " + apple);

        try {
            Orange orange = (Orange) fruitHolder.get();
        }catch (Exception e){
            e.printStackTrace();
            //fruitHolder.set(new Apple());
            //fruitHolder.set(new Fruit());
        }

        System.out.println(fruitHolder.equals(apple));

    }
}


/*
 * module: fundermental
 * file: GenericArrayWithTypeToken.java
 * date: 4/9/19 11:16 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 11:16
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {

    private T[] array;
    public GenericArrayWithTypeToken(Class<T> type,int size) {
        array = (T[]) Array.newInstance(type,size);
    }

    public void put(int index,T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> genericArrayWithTypeToken = new GenericArrayWithTypeToken<Integer>(Integer.class,10);
        Integer[] integers = genericArrayWithTypeToken.rep();
        System.out.println(integers.length);
    }
}


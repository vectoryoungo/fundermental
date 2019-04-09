/*
 * module: fundermental
 * file: GenericArrayT.java
 * date: 4/9/19 10:53 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 10:52
 * @desc refactor generic array
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class GenericArrayT<T> {

    private Object[] array;

    public GenericArrayT(int size) {
        array = new Object[size];
    }

    public void put(int index,T item) {
        array[index] = item;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public T[] rep() {
        return (T[])array;
    }

    public static void main(String[] args) {
        GenericArrayT<Integer> genericArrayT = new GenericArrayT<>(10);
        for (int i=0;i<10;i++) {
            genericArrayT.put(i,i);
        }

        for (int i=0;i<10;i++){
            System.out.println(genericArrayT.get(i) + " ");
        }
        System.out.println();
        try {
            Integer[] integers = genericArrayT.rep();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/*
 * module: fundermental
 * file: GenericArray.java
 * date: 4/9/19 10:41 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 10:41
 * @desc test of generic array
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class GenericArray<T> {

    private T[] array;

    public GenericArray(int size) {
        array = (T[]) new Object[size];
    }

    public void put(int index,T item) {
        array[index] = item;
    }

    public T get(int index){
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> genericArray = new GenericArray<>(10);
        //Integer[] integers = genericArray.rep();//ClassCastException [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
        //System.out.println(integers.length);
        Object[] objects = genericArray.rep();
        System.out.println(objects.length);
    }
}


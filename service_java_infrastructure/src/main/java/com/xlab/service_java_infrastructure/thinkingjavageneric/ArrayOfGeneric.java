/*
 * module: fundermental
 * file: ArrayOfGeneric.java
 * date: 4/9/19 10:01 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 10:01
 * @desc test of generic array
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class ArrayOfGeneric {

    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
        //gia = (Generic<Integer>[]) new Object[SIZE];
        gia = new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();
        System.out.println(gia[0]);
    }
}


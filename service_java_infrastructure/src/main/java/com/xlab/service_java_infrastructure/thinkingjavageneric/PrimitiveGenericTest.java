/*
 * module: fundermental
 * file: PrimitiveGenericTest.java
 * date: 4/10/19 3:04 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 15:04
 * @desc test of primitive generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class PrimitiveGenericTest {

    public static void main(String[] args) {
        String[] strings = FArray.fill(new String[7],new RandomGenerator.String(10));
        for (String s:strings) {
            System.out.println(s);
        }

        Integer[] integers = FArray.fill(new Integer[7],new RandomGenerator.Integer());

        for (int i:integers) {
            System.out.println(i);
        }

        //int[] b = FArray.fill(new int[7],new RandomGenerator.Integer());
    }
}


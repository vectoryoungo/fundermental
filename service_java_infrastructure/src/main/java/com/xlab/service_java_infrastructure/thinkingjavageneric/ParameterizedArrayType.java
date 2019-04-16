/*
 * module: fundermental
 * file: ParameterizedArrayType.java
 * date: 4/16/19 8:25 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-16 08:25
 * @desc test of generic array
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class ParameterizedArrayType {

    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,5,6,7};
        Double[] doubles = {1.1,2.2,3.3,4.4,5.5};

        Integer[] integers1 = new ClassParameter<Integer>().f(integers);
        System.out.println(integers1);
        System.out.println("size of integers1 " + integers1.length);

        Double[] doubles1 = MethodParameter.f(doubles);
        System.out.println(doubles1);
        System.out.println("size of doubles1 " + doubles1.length);
    }
}


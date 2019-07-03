/*
 * module: fundermental
 * file: ClientGeneric.java
 * date: 4/7/19 10:11 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 10:11
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.refactor;

public class ClientGeneric {

    public static void main(String[] args) {
        //DogWang dogWang = FactoryGeneric<DogWang>.createObject(DogWang.class);//expression expected
        FactoryGeneric<DogWang> factoryGeneric = new FactoryGeneric<DogWang>();
        DogWang dogWang = factoryGeneric.createObject(DogWang.class);
        System.out.println(dogWang);
    }
}


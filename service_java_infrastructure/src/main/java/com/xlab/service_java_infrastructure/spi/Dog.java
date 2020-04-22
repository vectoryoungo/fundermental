/*
 * module: fundermental
 * file: Dog.java
 * date: 4/22/20 10:30 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-22 22:30
 * @desc test spi
 **/
package com.xlab.service_java_infrastructure.spi;

public class Dog implements IShout {

    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}


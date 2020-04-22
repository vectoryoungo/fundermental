/*
 * module: fundermental
 * file: Cat.java
 * date: 4/22/20 10:29 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-22 22:29
 * @desc test spi
 **/
package com.xlab.service_java_infrastructure.spi;

public class Cat implements IShout {

    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}


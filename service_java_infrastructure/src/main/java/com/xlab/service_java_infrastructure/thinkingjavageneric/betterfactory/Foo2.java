/*
 * module: fundermental
 * file: Foo2.java
 * date: 4/9/19 8:43 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 08:43
 * @desc test of reveal generic factory
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric.betterfactory;

public class Foo2<T> {

    private T x;

    public <F extends Factory<T>> Foo2(F factory) {
        x = factory.create();
    }

    @Override
    public String toString() {
        return  x.getClass().getName() + " has been created !";
    }
}


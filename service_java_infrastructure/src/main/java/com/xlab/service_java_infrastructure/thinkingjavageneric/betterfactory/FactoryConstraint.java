/*
 * module: fundermental
 * file: FactoryConstraint.java
 * date: 4/9/19 8:49 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 08:49
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric.betterfactory;

public class FactoryConstraint {

    public static void main(String[] args) {
        System.out.println(new Foo2<Integer>(new IntegerFactory()));
        System.out.println(new Foo2<Widget>(new Widget.Factory()));
    }
}


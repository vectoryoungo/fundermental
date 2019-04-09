/*
 * module: fundermental
 * file: InheritBounds.java
 * date: 4/9/19 3:25 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 15:25
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class InheritBounds {

    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());
        System.out.println(solid2.color());
        System.out.println(solid2.getY());
        System.out.println(solid2.weight());
    }
}


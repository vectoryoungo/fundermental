/*
 * module: fundermental
 * file: BasicBounds.java
 * date: 4/9/19 2:36 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 14:36
 * @desc test of generic extends
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        System.out.println(solid.color());
        System.out.println(solid.getY());
        System.out.println(solid.weight());
    }
}


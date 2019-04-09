/*
 * module: fundermental
 * file: Solid.java
 * date: 4/9/19 2:29 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 14:29
 * @desc test of generic extends
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class Solid<T extends Dimension & HasColor & Weight> {
    T item;

    Solid(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
       return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

    int weight() {
        return item.weight();
    }
}

